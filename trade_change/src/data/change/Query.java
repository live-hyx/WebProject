package data.change;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

public class Query extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
	    String indexId=request.getParameter("index_id");

	    List jsonList=new ArrayList();
	    try{
	        Class.forName("com.mysql.jdbc.Driver");
	    }catch (ClassNotFoundException clssNotFoundException){
	        clssNotFoundException.printStackTrace();
	    }
	    try{
	        String url="jdbc:mysql://localhost:3306/test";
	        Connection con=DriverManager.getConnection(url,"dbuser","123456");
	        Statement stmt=con.createStatement();
	        System.out.println("数据库连接成功!");
	        String sql="select * from trade_index where index_id =" + "'"+indexId+"';";

	        System.out.println("构造的sql语句是:"+sql);
	        ResultSet rs=stmt.executeQuery(sql);
	        while(rs.next()){
	            Map map=new HashMap();
	            map.put("index_id",rs.getString("index_id"));
	            map.put("index_name",rs.getString("index_name"));
	            map.put("index_value",rs.getString("index_value"));
	            map.put("up_down",rs.getString("up_down"));
	            map.put("rise_fall",rs.getString("rise_fall"));
	            map.put("quantity",rs.getString("quantity"));
	            map.put("price",rs.getString("price"));
	            jsonList.add(map);
	        }
	        stmt.close();
	        con.close();
	        System.out.println("数据库关闭!");
	    }catch (SQLException sqlexception){
	        sqlexception.printStackTrace();
	    }
	    
	  //回传
	    JSONObject json=new JSONObject();
	    try {
			json.put("aaData",jsonList);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    try {
			json.put("result_msg","ok");
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    try {
			json.put("result_code",0);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    System.out.println("最后构造的json是"+json.toString());
	    response.setContentType("text/html;charset=UTF-8");
	    try{
	        response.getWriter().print(json);
	        response.getWriter().flush();
	        response.getWriter().close();
	    }catch (IOException e){
	        e.printStackTrace();
	    }
	    System.out.println("返回给调用页面了!");
	   
	}
}
