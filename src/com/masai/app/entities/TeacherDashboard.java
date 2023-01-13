package com.masai.app.entities;


public class TeacherDashboard extends ClerkDashboard {
	
	
	private User teacher;
	
	public TeacherDashboard(User teacher) throws Exception {
		super(teacher);
		
	}
	
	

	/**Can see the fee record of student classwise
	 * @throws Exception **/
	public void seeFeeClasswise(String classno) throws Exception {
		if(!isLoggedIn()) {
			throw new Exception("Login as teacher to access the teacher Dashboard");
		}
		for(Student s:getStudents()) {
			
			if(s.getClassNo().equals(classno)) {
				
				System.out.println(s.getName()+"fee status:"+s.getStatus());
			}
		}
	
		System.out.println("----------------------------------");
		return;
	}
	
}
