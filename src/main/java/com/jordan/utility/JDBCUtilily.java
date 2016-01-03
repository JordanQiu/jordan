package com.jordan.utility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 封装重用代码
 * 获取Jdbc连接，释放资源
 * @author Administrator
 *
 */
public class JDBCUtilily {
	
	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/insurance";
	public static final String DBUSER = "root";
	public static final String DBPASS = "seven";
	static {
		try {
		//加载驱动	
                    Class.forName(DBDRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		Connection conn = null;
		String url = DBURL;//获取URL
		String user = DBUSER;//获取登录名
		String pwd = DBPASS;//获取登录密码
		try {
                    //连接数据库
		conn = DriverManager.getConnection(url,user,pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	//释放资源
	public static void release(Object o) throws SQLException{
		if (o == null){
			return;
		}
		if (o instanceof ResultSet){
			try {
				((ResultSet)o).close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if(o instanceof Statement){
			try {
				((Statement)o).close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (o instanceof Connection){
			Connection c = (Connection)o;
		
				if (!c.isClosed()){
					c.close();
				}
			
		}
		
	}
	
         public static void release(ResultSet rs, Statement stmt, 
                             Connection conn){
		try {
			release(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			release(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			release(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
