package com.masai.app.entities;

public class AdminDashboard extends Dashboard {
	
	
	private User admin;
	
	public AdminDashboard(User admin) throws Exception {
		super(admin);
		
	}

	/**Total Students 
	 * @throws Exception **/
	public void totalStudents() throws Exception {
		if(!isLoggedIn()) {
			throw new Exception("Login as Admin to access the admin dashboard");
		}
		System.out.println("total number of students :"+getStudents().size());
		for(Student s:getStudents()) {
			System.out.println("ID:"+s.getId());
			System.out.println("Name :"+s.getName());
			System.out.println("City :"+s.getCity());
			System.out.println("Class :"+s.getClassNo());
			System.out.println("Fee Status :"+s.getStatus());
		}
		System.out.println("----------------------------------");
	}
	
	
	/**Classwise Student details 
	 * @throws Exception **/
	public void studentDetails(String classNo) throws Exception {
		if(!isLoggedIn()) {
			throw new Exception("Login as Admin to access the admin dashboard");
		}
		for(Student s:getStudents()) {
			if(s.getClassNo().equalsIgnoreCase(classNo)) {
				System.out.println("total number of students :"+s.getId());
				System.out.println("total number of students :"+s.getName());
				System.out.println("total number of students :"+s.getCity());
				System.out.println("total number of students :"+s.getClassNo());
				System.out.println("total number of students :"+s.getFee());
			}
		}
		System.out.println("----------------------------------");
	}
	
	/**Getting one student 
	 * @throws Exception **/
	public void getStudent(int studentId) throws Exception {
		if(!isLoggedIn()) {
			throw new Exception("Login as Admin to access the admin dashboard");
		}
		for(Student s:getStudents()) {
			if(s.getId()==studentId) {
				System.out.println("ID:"+s.getId());
				System.out.println("Name :"+s.getName());
				System.out.println("City :"+s.getCity());
				System.out.println("Class :"+s.getClassNo());
				System.out.println("Fee Status :"+s.getStatus());
				break;
			}
		}
		System.out.println("----------------------------------");
	}
	
	/**Total sum of fee paid this month by a particular student
	 * @throws Exception **/
	public void totalSumPaid(Student student) throws Exception {
		if(!isLoggedIn()) {
			throw new Exception("Login as Admin to access the admin dashboard");
		}
		if(getStudents().contains(student)) {
			int total_sum=student.getFee().getTotal_sum();
			System.out.println("The total sum paid by"+student.getName()+"is"+total_sum);
			
		}else {
			throw new Exception("Student does not exist");
		}
		System.out.println("----------------------------------");
	}
	
	
	
}
