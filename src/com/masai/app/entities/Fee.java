package com.masai.app.entities;

public class Fee {

	private int first_installment=0;
	private int second_installment=0;
	private int third_installment=0;
	private int fourth_installment=0;
	private int total_sum;
	public int getFirst_installment() {
		return first_installment;
	}
	public void setFirst_installment(int first_installment) {
		this.first_installment = first_installment;
	}
	public int getSecond_installment() {
		return second_installment;
	}
	public void setSecond_installment(int second_installment) {
		this.second_installment = second_installment;
	}
	public int getThird_installment() {
		return third_installment;
	}
	public void setThird_installment(int third_installment) {
		this.third_installment = third_installment;
	}
	public int getFourth_installment() {
		return fourth_installment;
	}
	public void setFourth_installment(int fourth_installment) {
		this.fourth_installment = fourth_installment;
	}
	public Fee(int first_installment, int second_installment, int third_installment, int fourth_installment) {
		super();
		this.first_installment = first_installment;
		this.second_installment = second_installment;
		this.third_installment = third_installment;
		this.fourth_installment = fourth_installment;
	}
	public int getTotal_sum() {
		return this.first_installment+this.second_installment+this.third_installment
				+this.fourth_installment;
	}
	
	
	
}
