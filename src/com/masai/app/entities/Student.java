package com.masai.app.entities;

public class Student {
	
	private int id;
	private String name;
	private String city;
	private String classno;
	private Fee fee;
	String status="not_paid"; //initially no amount of has been paid
	
	public Student() {
		
	}
	
	public Student(int id, String name, String city, String classno) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.classno = classno;
		
	}
	
	public Student(int id, String name, String city, String classno,Fee fee,String status) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.classno = classno;
		this.fee=fee;
		this.status=status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getClassNo() {
		return this.classno;
	}

	public void setClassNo(String classNo) {
		this.classno = classNo;
	}

	public Fee getFee() {
		return fee;
	}

	public void setFee(Fee fee) {
		this.fee = fee;
	}

	public String getClassno() {
		return classno;
	}

	public void setClassno(String classno) {
		this.classno = classno;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", city=" + city + ", classno=" + classno + ", fee=" + fee
				+ ", status=" + status + "]";
	}

	
	
	
	
	
	
	

}
