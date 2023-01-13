package com.masai.app.entities;

public class Admin extends User {

	
	
	public Admin(String username,String password) {
		super(username,password);
	}

	@Override
	public void login() throws Exception {
		if(getUsername().equals("Admin") && getPassword().equals("Admin@1234")) {
			System.out.println("Admin has logged in");
			setLoggedIn(true);
		}
		else {
			throw new Exception("Invalid teacher credentials");
		}
		System.out.println("----------------------------------");
		
	}

	@Override
	public void logout() {
		System.out.println("Admin logged out");
		setLoggedIn(false);
		System.out.println("----------------------------------");
		
	}

	
	
	
}
