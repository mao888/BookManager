package com.java.util;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * ���ݿ⹤����
 * @author Administrator
 * �Զ�������ctrl shift + o
 * 
 * */
public class DbUtil {
	
	private String dbUrl="jdbc:mysql://localhost:3306/db_book?useUnicode=true&characterEncoding=utf8&&useSSL=false&serverTimezone = Asia/Shanghai ";
	private String duUsername="root";		//�û�
	private String dbPassword="10428376";  //����
	private String jdbcName="com.mysql.jdbc.Driver";	//��������
	
	/*
	 * ��ȡ���ݿ�����
	 * @return
	 * @throws Exception
	 * */
	public Connection getCon() throws Exception {
		Class.forName(jdbcName);
		Connection con= DriverManager.getConnection(dbUrl, duUsername, dbPassword);
		return con;
	}
	
	
	/*
	 * �ر����ݿ�
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
			System.out.println("���ݿ����ӳɹ���");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("���ݿ�����ʧ�ܣ�");
		}
	}
}




                                    