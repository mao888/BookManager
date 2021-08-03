package com.java.model;

public class User {
	
	
	//从父类生成构造方法
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//使用字段生成构造方法
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}


	private int id;	//编号
	private String username;	//用户名
	private String password;	//密码
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
