package com.masai.app.entities;

/**Assumptions while paying the fee for the student
 * 
 * @author Shilp
 * We are assuming that the fee paid for the student is the exact amount as any of 
 * the installments and hence no exchange money is returned
 *
 */

/** login creds for clerk,teacher and Admin
 * 
 * @author Shilp
 *
 *1) Clerk : username: "Clerk" password="Clerk@1234"
 *2) Teacher : username: "Teacher" password="Teacher@1234"
 *3) Admin: username: "Admin" password="Admin@1234"
 *
 *Any User(clerk,teacher,Admin) cannot access their respective dashboards if they are not
 *loggedIn
 *
 *payment status of a student are of 4 types
 *1) first_installment(first_paid)
 *2)Second_installment(second_paid)
 *3)Third_installment(third_paid)
 *4)fourth_installment(full_paid)
 *
 * And fee can be paid in one full installment also which will change the
 * payment status of the student to full_paid
 * 
 * Exception will be thrown if the user is not logged in and trying to access the
 * ERP application
 *
 */
public class ERP {

	public static void main(String[] args) throws Exception {
		
		Student s1=new Student(1,"Shilp","abad","C");
		Student s2=new Student(2,"Isha","Meerut","D");
		Student s3=new Student(3,"Harsh","Lucknow","C");
		Fee fee1=new Fee(100,200,300,400);
		Fee fee2=new Fee(100,200,300,500);
		Fee fee3=new Fee(100,900,500,1500);
		s1.setFee(fee1); //fee to be paid by s1
		s2.setFee(fee2);
		s3.setFee(fee3);
		
		/**All the clerk methods will be implemented **/
		User clerk1=new Clerk("Clerk", "Clerk@1234");
		clerk1.login();
		ClerkDashboard clerkDashboard=new ClerkDashboard(clerk1);
		clerkDashboard.addStudent(s1);
		clerkDashboard.addStudent(s2);
		clerkDashboard.addStudent(s3);
		//clerk1.logout();
		clerkDashboard.feeRecord(s3);
		clerkDashboard.addFee(s3, 100);
		clerkDashboard.feeRecord(s3);
		clerkDashboard.studentDetails("C");
		clerkDashboard.payFull(s1,s1.getFee().getTotal_sum());
		
		/** All the teacher methods will be implemented**/
		User teacher =new Teacher("Teacher","Teacher@1234");
		teacher.login();
		TeacherDashboard teacherDashboard=new TeacherDashboard(teacher);
		teacherDashboard.seeFeeClasswise("C");
		teacherDashboard.getAllStudents();
		teacherDashboard.feeRecord(s3);
		
		/**All the admin methods will be implemented **/
		User admin=new Admin("Admin","Admin@1234");
		admin.login();
		AdminDashboard adminDashboard=new AdminDashboard(admin);
		adminDashboard.getStudents();
		adminDashboard.getStudent(1);
		adminDashboard.totalStudents();
		adminDashboard.totalSumPaid(s3);
		
	}

}
