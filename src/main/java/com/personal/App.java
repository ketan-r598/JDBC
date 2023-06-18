package com.personal;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.personal.connection.ConnectionUtils;
import com.personal.dao.EmployeeDAO;
import com.personal.dao.EmployeeDAOImpl;
import com.personal.model.Employee;

public class App {
	public static void main(String[] args) {

		Connection conn = ConnectionUtils.getConnection();
		EmployeeDAO dao = new EmployeeDAOImpl(conn);

		Employee emp1 = new Employee(101, "ABC", "12325456");
		Employee emp2 = new Employee(102, "DEF", "45466573");
		Employee emp3 = new Employee(103, "GHI", "98665324");

		try {
			// Insert three data-items

			dao.insert(emp1);
			dao.insert(emp2);
			dao.insert(emp3);

			// Reading the data from the database and write it to the console
			List<Employee> empList = dao.readAll();

			for (Employee emp : empList) {
				System.out.println(emp);
			}

			// Updating the name of the record with eid 102 and name
			// from DEF -> XYZ

			dao.update(102, "ename", "XYZ");

			// Reading the data from the database and write it to the console
			empList = dao.readAll();
			System.out.println();
			for (Employee emp : empList) {
				System.out.println(emp);
			}
			
			// deleting the record with eid 103
			dao.delete(103);
			
			empList = dao.readAll();
			
			System.out.println();
			for (Employee emp : empList) {
				System.out.println(emp);
			}

			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
