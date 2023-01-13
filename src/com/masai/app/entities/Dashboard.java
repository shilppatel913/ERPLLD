package com.masai.app.entities;

import java.util.ArrayList;
import java.util.List;

public class Dashboard {
	private User user;
	private static List<Student> students;
	static {
		students=new ArrayList<>();
	}
	public Dashboard(User user) {
		this.user=user;
	};
	public List<Student> getStudents() {
		return students;
	}

	public boolean isLoggedIn() {
		return user.isLoggedIn();
	}
	
	
	
}
