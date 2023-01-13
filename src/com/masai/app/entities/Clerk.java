package com.masai.app.entities;

public class Clerk extends User {
	
	
	
	public Clerk(String username,String password) {
		super(username,password);
	}

	@Override
	public void login() throws Exception{
		if(getUsername().equals("Clerk") && getPassword().equals("Clerk@1234")) {
			System.out.println("Successfully logged in as clerk");
			setLoggedIn(true);
		}else {
			throw new Exception("Invalid credentials for clerk");
		}
		System.out.println("----------------------------------");
		return;
		
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		System.out.println("Clerk logged out");
		setLoggedIn(false);
		System.out.println("----------------------------------");
		
	}



	

	
}
