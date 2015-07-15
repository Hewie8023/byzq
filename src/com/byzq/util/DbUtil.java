package com.byzq.util;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class DbUtil {

	private static String name = "root";
	private static String passwd = "802326";
	private static String url = "jdbc:mysql://localhost:3306/musicstation";

	/**
	 * 获取数据库的连接
	 * 
	 * @author Hewie
	 * @return con
	 */
	public static Connection getConnection() {

		Connection con = null;
		try {
			Driver d = new Driver();
			DriverManager.registerDriver(d);

			con = (Connection) DriverManager.getConnection(url, name, passwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return con;
	}

	/**
	 * 关闭数据库的连接
	 * 
	 * @author Hewie
	 * @date 2015-7-4
	 */
	public static void closeCon(Connection con, ResultSet rs, Statement st) {
		try {
			if (con != null) {
				con.close();
			}
			if(rs!=null){
				rs.close();
			}
			if(st!=null){
				st.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
