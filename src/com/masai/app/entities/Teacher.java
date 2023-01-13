package com.masai.app.entities;

public class Teacher extends Clerk{

	
	public Teacher(String username, String password) {
		super(username, password);
		
	}

	@Override
	public void login() throws Exception {
		if(getUsername().equals("Teacher") && getPassword().equals("Teacher@1234")) {
			System.out.println("The teacher has logged in");
			setLoggedIn(true);
		}
		else {
			throw new Exception("Invalid teacher credentials");
		}
		System.out.println("----------------------------------");
	}

	@Override
	public void logout() {
		System.out.println("the teacher has logged out");
		setLoggedIn(false);
		System.out.println("----------------------------------");
		
	}


	
	

}
