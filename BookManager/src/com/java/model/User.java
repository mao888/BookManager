package com.java.model;

public class User {
	
	
	//�Ӹ������ɹ��췽��
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//ʹ���ֶ����ɹ��췽��
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}


	private int id;	//���
	private String username;	//�û���
	private String password;	//����
	
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
