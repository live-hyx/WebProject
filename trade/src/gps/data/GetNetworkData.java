package gps.data;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

public class GetNetworkData implements ServletContextListener {
	private Timer timer = null;
	private TimerTask task=null;
	
	public void contextDestroyed(ServletContextEvent arg0) {
	}


	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("================>[ServletContextListener]自动加载启动开始.");
		timer = new Timer(true);
		java.util.Date date = (new Date());
		MyTimerTask task = new MyTimerTask();
		timer.schedule(task, 2000,30000);		//延迟2秒后，每隔20秒运行一次
		System.out.println("[GetNetworkData]运行了");
	}
	public class MyTimerTask extends TimerTask {

	    public void run() {
	        Calendar calendar = Calendar.getInstance();
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        System.out.println("Current Time："+format.format(calendar.getTime()));//获取当前系统时间
	        try {//多用函数
				getGPSData();
			} catch (MalformedURLException | JSONException | SQLException e) {
				e.printStackTrace();
			}
	    }
	}
	public void getGPSData() throws MalformedURLException, JSONException, SQLException{
		 try {
	            //创建一个URL实例
	            URL url = new URL("http://hq.sinajs.cn/list=s_sh000001,s_sh000002,s_sh000003,s_sh000004,s_sh000005,s_sh000006,s_sh000007,s_sh000010,s_sh000011,s_sh000012,s_sh000013,s_sh000015,s_sh000016,s_sh000017,s_sh000019,s_sh000042,s_sh000043,s_sh000049,s_sh000054,s_sh000055,s_sh000056,s_sh000057,s_sh000058,s_sh000059,s_sh000060,s_sh000061,s_sh000062,s_sh000063,s_sh000064,s_sh000066,s_sh000067,s_sh000300");

	            try {
	                //通过URL的openStrean方法获取URL对象所表示的自愿字节输入流
	                InputStream is = url.openStream();
	                InputStreamReader isr = new InputStreamReader(is,"GBK");

	                //为字符输入流添加缓冲
	                BufferedReader br = new BufferedReader(isr);
	                String data = br.readLine();//读取数据

	               while (data!=null){//循环读取数据
	            	   	GPSDao dao=new GPSDao();
		                dao.addGPSRecord(data);
	                    data = br.readLine();
	                }
	                System.out.println(data);
	                
	                br.close();
	                isr.close();
	                is.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        }
	}
}
