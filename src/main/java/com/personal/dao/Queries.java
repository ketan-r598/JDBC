package com.personal.dao;

public class Queries {

	public static String insert;
	public static String update;
	public static String delete;
	public static String read;

	static {
		insert = "INSERT INTO Employee (eid, ename, phoneNumber) VALUES (?, ?, ?)";
		update = "UPDATE Employee set ename = ? where eid = ?";
		delete = "DELETE FROM Employee WHERE eid = ?";
		read = "SELECT * FROM Employee";
	}
}