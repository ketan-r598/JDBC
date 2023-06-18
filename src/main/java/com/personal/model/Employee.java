package com.personal.model;

public class Employee {

	private int eid;
	private String ename;
	private String phoneNumber;

	public Employee() {

	}

	public Employee(int eid, String ename, String phoneNumber) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.phoneNumber = phoneNumber;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", phoneNumber=" + phoneNumber + "]";
	}
}