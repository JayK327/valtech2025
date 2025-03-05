package com.valtech.training.springweb.vos;

public class LoginVO {//its like a bean
	private String username;
	private String password;
	//name and case should be same as login.jsp page
	
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
