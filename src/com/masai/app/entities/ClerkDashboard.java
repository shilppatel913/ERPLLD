package com.masai.app.entities;


public class ClerkDashboard extends Dashboard{
	
	private User clerk;
	public ClerkDashboard(User clerk) throws Exception {
		super(clerk);
	}

	/**once clerk has logged in he will see this dashboard
	 * and can perform the given operations on student
	 * 
	 */

	public void addStudent(Student student) throws Exception {
		if(!isLoggedIn()) {
			throw new Exception("First login to access the Clerk Dashboard ");
		}
		if(getStudents().contains(student)) {
			System.out.println("Student is already present");
			return;
		}
		getStudents().add(student);
		
		
		return;
		
	}
	
	/**getting all the students
	 * @throws Exception **/
	public void getAllStudents() throws Exception {
		if(!isLoggedIn()) {
			throw new Exception("First login to access the Clerk Dashboard ");
		}
		System.out.println("List of Students");
		for(Student s:getStudents()) {
			System.out.println(s.getName());
		}
		System.out.println("----------------------------------");
	}
	
	/**get one particular student**/
	/**Getting one student 
	 * @throws Exception **/
	public void getStudent(int studentId) throws Exception {
		if(!isLoggedIn()) {
			throw new Exception("First login to access the Clerk Dashboard ");
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
	
	
	/**Delete a student 
	 * @throws Exception **/
	public void deleteStudent(int studentId) throws Exception {
		if(!isLoggedIn()) {
			throw new Exception("First login to access the Clerk Dashboard ");
		}
		for(Student s:getStudents()) {
			if(s.getId()==studentId) {
				getStudents().remove(s);
				System.out.println("The student has been deleted successfully");
				break;
			}
		}
		System.out.println("----------------------------------");
		return;
		
	}
	
	
	/**fee record of a particular student
	 * @throws Exception **/
	public void feeRecord(Student student) throws Exception {
		if(!isLoggedIn()) {
			throw new Exception("First login to access the Clerk Dashboard ");
		}
		if(!getStudents().contains(student)) {
			System.out.println("Student not present in the database");
			return;
		}
		System.out.println(student.getName()+" fee status:"+student.getStatus());
		System.out.println("----------------------------------");
	}
	
	/**Classwise Student details 
	 * @throws Exception **/
	public void studentDetails(String classNo) throws Exception {
		if(!isLoggedIn()) {
			throw new Exception("First login to access the Clerk Dashboard ");
		}
		for(Student s:getStudents()) {
			if(s.getClassNo().equalsIgnoreCase(classNo)) {
				System.out.println("ID:"+s.getId());
				System.out.println("Name :"+s.getName());
				System.out.println("City :"+s.getCity());
				System.out.println("Class :"+s.getClassNo());
				System.out.println("Fee Status :"+s.getStatus());
			}
		}
		System.out.println("----------------------------------");
	}
	
	/**final keyword so that the teacher dashboard cannot override this method 
	 * @throws Exception **/
	public final void addFee(Student student,int amount_to_add) throws Exception {
		if(!isLoggedIn()) {
			throw new Exception("First login to access the Clerk Dashboard ");
		}
		if(!getStudents().contains(student)) {
			System.out.println("Student not present in the database so cannot add fee");
			return;
		}
		/**check the status first and then update the corresponding installment paid **/
		if(student.getStatus().equalsIgnoreCase("not_paid")) {
			if(amount_to_add<student.getFee().getFirst_installment()) {
				throw new Exception("The amount entered in less than the total amount");
			}
			
		student.getFee().setFirst_installment(student.getFee().getFirst_installment()-
				amount_to_add);
		
		if(student.getFee().getFirst_installment()<=0) {
			student.setStatus("first_paid");
			System.out.println("First installment for "+student.getName()+" paid successfully");
		}
			
		}else if(student.getStatus().equalsIgnoreCase("first_paid")) {
			if(amount_to_add<student.getFee().getSecond_installment()) {
				throw new Exception("The amount entered in less than the total amount");
			}
			student.getFee().setSecond_installment(student.getFee().getSecond_installment()-
				amount_to_add);
			
			if(student.getFee().getSecond_installment()<=0) {
				student.setStatus("second_paid");
				System.out.println("Second installment for "+student.getName()+" paid successfully");
			}
			
		}else if(student.getStatus().equalsIgnoreCase("second_paid")) {
			if(amount_to_add<student.getFee().getThird_installment()) {
				throw new Exception("The amount entered in less than the total amount");
			}
			student.getFee().setThird_installment(student.getFee().getThird_installment()-
					amount_to_add);
			
			if(student.getFee().getThird_installment()<=0) {
				student.setStatus("third_paid");
				System.out.println("Third installment for "+student.getName()+" paid successfully");
			}
			
		}else if(student.getStatus().equalsIgnoreCase("third_paid")) {
			if(amount_to_add<student.getFee().getFourth_installment()) {
				throw new Exception("The amount entered in less than the total amount");
			}
			student.getFee().setFourth_installment(student.getFee().getFourth_installment()-
					amount_to_add);
			
			if(student.getFee().getFourth_installment()<=0) {
				student.setStatus("full_paid");
				System.out.println("Fourth installment for "+student.getName()+" paid successfully");
			}
			
		}
		System.out.println("----------------------------------");
	}
	
	public final void payFull(Student student,int amount_to_add) throws Exception {
		if(amount_to_add<student.getFee().getTotal_sum()) {
			throw new Exception("The amount entered in less than the total amount");
		}
		if(!isLoggedIn()) {
			throw new Exception("First login to access the Clerk Dashboard ");
		}
		if(student.getStatus().equalsIgnoreCase("full_paid")) {
			System.out.println("The fee has already been paid by "+student.getName());
			return;
		}
		Fee fee=student.getFee();
		fee.setFirst_installment(0);
		fee.setSecond_installment(0);
		fee.setThird_installment(0);
		fee.setFourth_installment(0);
		student.setStatus("full_paid");
		System.out.println("Full fee for "+student.getName()+" paid successfully");
		System.out.println("----------------------------------");
		return;
	}

	
	
	
}
