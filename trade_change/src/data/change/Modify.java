package data.change;
import java.awt.List;
import java.io.IOException;
//多用函数分开
//每个函数入口检查参数是否正确
//循序渐渐，一步步来，做一步，运行检验一步
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Modify extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		String action=request.getParameter("action");
	    String indexId=request.getParameter("index_id");
	    String indexName=request.getParameter("index_name");
	    String modified_indexName = request.getParameter("modified_index_name");
	 
	    try{
	        Class.forName("com.mysql.jdbc.Driver");
	    }catch (ClassNotFoundException clssNotFoundException){
	        clssNotFoundException.printStackTrace();
	    }
	    try{
	    	Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=123456&useUnicode=true&characterEncoding=UTF-8");
	        Statement stmt=con.createStatement();
	        System.out.println("数据库连接成功!");
	        String sql = "update trade_index set " + "index_name=" + "'" + modified_indexName + "'" + " where index_id=" + "'" + indexId +"';";
	        stmt.executeUpdate(sql);
	        stmt.close();
	        con.close();
	        System.out.println(sql);
	        System.out.println("数据库关闭!");
	        }catch (SQLException sqlexception){
		        sqlexception.printStackTrace();
		    }
}
}
