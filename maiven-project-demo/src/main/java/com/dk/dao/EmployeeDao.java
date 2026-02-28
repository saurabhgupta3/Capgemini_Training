package com.dk.dao;

import java.sql.*;
import com.dk.model.Employee;

public class EmployeeDao {
	
    public Employee addEmployee(Employee emp) throws SQLException {

        String sql = "INSERT INTO employee VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, emp.getEmployee_id());
            stmt.setString(2, emp.getFirst_name());
            stmt.setString(3, emp.getLast_name());
            stmt.setString(4, emp.getEmail());
            stmt.setString(5, emp.getPhone_number());
            stmt.setDate(6, emp.getHire_date());
            stmt.setString(7, emp.getJob_title());
            stmt.setDouble(8, emp.getSalary());
            stmt.setInt(9, emp.getManager_id());
            stmt.setInt(10, emp.getDepartment_id());

            int rows = stmt.executeUpdate();

            if (rows != 1) {
                throw new RuntimeException("Insert failed");
            }

            return emp;
        }
    }

    public Employee getEmployee(int id) throws SQLException {

        String sql = "SELECT * FROM employee WHERE employee_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {

                    Employee emp = new Employee();

                    emp.setEmployee_id(rs.getInt("employee_id"));
                    emp.setFirst_name(rs.getString("first_name"));
                    emp.setLast_name(rs.getString("last_name"));
                    emp.setEmail(rs.getString("email"));
                    emp.setPhone_number(rs.getString("phone_number"));
                    emp.setHire_date(rs.getDate("hire_date"));
                    emp.setJob_title(rs.getString("job_title"));
                    emp.setSalary(rs.getDouble("salary"));
                    emp.setManager_id(rs.getInt("manager_id"));
                    emp.setDepartment_id(rs.getInt("department_id"));

                    return emp;
                }
            }
        }

        return null;
    }


    public boolean deleteEmployee(int empId) throws SQLException {

        String sql = "DELETE FROM employee WHERE employee_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, empId);

            int rows = stmt.executeUpdate();

            if(rows != 1) {
            	throw new RuntimeException("some sql error occured");
            } else {
            	return true;
            }
        }
    }

    public void printAllEmployee() throws SQLException {

        String sql = "SELECT * FROM employee";

        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("employee_id") + " " + 
                        rs.getString("first_name") + " " + 
                        rs.getString("last_name") +  " " + 
                        rs.getDouble("salary")
                );
            }
        }
    }

    public static void main(String[] args) throws Exception {

        EmployeeDao dao = new EmployeeDao();

        dao.printAllEmployee();

        dao.deleteEmployee(205);

        dao.printAllEmployee();
    }
}