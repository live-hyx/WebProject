package gps.data;
import java.awt.List;
//多用函数分开
//每个函数入口检查参数是否正确
//循序渐渐，一步步来，做一步，运行检验一步
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GPSDao {
	Statement statement=null;
	public void addGPSRecord(String data) throws JSONException, SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException classnotfoundexception) {
			classnotfoundexception.printStackTrace();
		}
		System.out.println("加载了JDBC驱动");
		Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=123456&useUnicode=true&characterEncoding=UTF-8");
		System.out.println("准备statement。");
		statement = conn.createStatement();
		System.out.println("已经链接上数据库！");
		System.out.println("Connect Database Ok！！！<br>");
		////////////////////////////////////////////////////

		String[] list;
		list=data.split("=");
	    String left=list[0];
	    String right=list[1];
	    //
	    list=left.split(" ");
	    list=list[1].split("_");
	    String indexId=list[3];
	    //
	    right=right.replace("\"","");
	  
	    list=right.split(",");
	    String indexName=list[0];
	    String indexValue=list[1];
	    String up_down=list[2];
	    String rise_fall=list[3];
	    String quantity=list[4];
	    String price=list[5];
	    price=price.substring(0, price.length()-1);

		String creatorId="2018141461172";
		String creator="超管";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String createTime=format.format(new Date());
	    try {
			String sql = "insert into trade_index(index_id,index_name,index_value,up_down,rise_fall,quantity,price,creator_id,creator,create_time) values('"
					+ indexId +"','"+indexName +"','"+indexValue+"','"+up_down+"','"+rise_fall+"','"+quantity+"','"+price+"','"+creatorId+"','"+creator+"','"+createTime+"')";
			System.out.println("即将执行的SQL语句是："+sql);
			statement.executeUpdate(sql);
		} catch (SQLException sqlexception) {
			sqlexception.printStackTrace();
		}
		statement.close();
		conn.close();
		System.out.println("Database Closed！！！<br>");
		System.out.println("操作数据完毕，关闭了数据库！");
	}
}
