package com.masai.app.entities;

public abstract class User {
	
	private String username;
	private String password;
	private boolean isLoggedIn=false;
	
	public User(String username,String password) {
		this.username=username;
		this.password=password;
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



	public abstract void login() throws Exception;
	public abstract void logout();



	public boolean isLoggedIn() {
		return isLoggedIn;
	}



	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}



}
