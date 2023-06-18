package com.personal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.personal.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	private Connection conn;

	public EmployeeDAOImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Employee emp) throws SQLException {

		String query = Queries.insert;

		PreparedStatement stmt = conn.prepareStatement(query);

		stmt.setInt(1, emp.getEid());
		stmt.setString(2, emp.getEname());
		stmt.setString(3, emp.getPhoneNumber());

		stmt.execute();

		System.out.println("Insert statement executed ");
	}

	@Override
	public boolean update(int empId, String field, String value) throws SQLException {

		String query = Queries.update;

		PreparedStatement stmt = conn.prepareStatement(query);

//		stmt.setString(1, field);
		stmt.setString(1, value);
		stmt.setInt(2, empId);

		int retVal = stmt.executeUpdate();

		if (retVal > 0) {
			System.out.println("Executed the query Successfully");
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int empId) throws SQLException {

		String query = Queries.delete;

		PreparedStatement stmt = conn.prepareStatement(query);

		stmt.setInt(1, empId);

		stmt.execute();

		return true;
	}

	@Override
	public List<Employee> readAll() throws SQLException {

		String query = Queries.read;

		PreparedStatement stmt = conn.prepareStatement(query);

		ResultSet set = stmt.executeQuery();

		List<Employee> empList = new ArrayList<>();

		while (set.next()) {

			empList.add(new Employee(set.getInt(1), set.getString(2), set.getString(3)));
		}

		return empList;
	}
}