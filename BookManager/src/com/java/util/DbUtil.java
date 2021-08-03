package com.java.util;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * 数据库工具类
 * @author Administrator
 * 自动导入类ctrl shift + o
 * 
 * */
public class DbUtil {
	
	private String dbUrl="jdbc:mysql://localhost:3306/db_book?useUnicode=true&characterEncoding=utf8&&useSSL=false&serverTimezone = Asia/Shanghai ";
	private String duUsername="root";		//用户
	private String dbPassword="10428376";  //密码
	private String jdbcName="com.mysql.jdbc.Driver";	//驱动名称
	
	/*
	 * 获取数据库连接
	 * @return
	 * @throws Exception
	 * */
	public Connection getCon() throws Exception {
		Class.forName(jdbcName);
		Connection con= DriverManager.getConnection(dbUrl, duUsername, dbPassword);
		return con;
	}
	
	
	/*
	 * 关闭数据库
	 * @param con
	 * @throws Exception
	 * */
	public void closeCon(Connection con) throws Exception{
		if (con!=null) {
			con.close();
		}
	}
	
	
	public static void main(String[] args) {
		DbUtil dbutil = new DbUtil();
		try {
			dbutil.getCon();
			System.out.println("数据库连接成功！");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("数据库连接失败！");
		}
	}
}




                                    