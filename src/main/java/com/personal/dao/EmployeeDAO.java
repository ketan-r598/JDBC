package com.personal.dao;

import java.sql.SQLException;
import java.util.List;

import com.personal.model.Employee;

public interface EmployeeDAO {
	
	void insert(Employee emp) throws SQLException;
	boolean update(int empId, String field, String value) throws SQLException;
	boolean delete(int empId) throws SQLException;

	List<Employee> readAll() throws SQLException;
}