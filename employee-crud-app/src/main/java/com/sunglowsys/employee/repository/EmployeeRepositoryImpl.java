package com.sunglowsys.employee.repository;

import com.sunglowsys.employee.db.DbConnection;
import com.sunglowsys.employee.domain.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository{
    Connection connection = DbConnection.getConnection();
    @Override
    public void save(Employee employee) {
        String sql = "insert into employee(first_name, last_name, email, mobile, gender, department) values(?,?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,employee.getFirstName());
            statement.setString(2,employee.getLastName());
            statement.setString(3,employee.getEmail());
            statement.setString(4,employee.getMobile());
            statement.setString(5,employee.getGender());
            statement.setString(6,employee.getDepartment());

            int result = statement.executeUpdate();
            if(result>0){
                System.out.println("created----");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Employee employee) {
       String sql = "update employee set department = ? where id= ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,employee.getEmail());
            statement.setLong(2,employee.getId());
            int result = statement.executeUpdate();
            if(result>0){
                System.out.println("updated---");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        String sql = "select *from employee";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Long e_id = resultSet.getLong(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String email = resultSet.getString(4);
                String mobile = resultSet.getString(5);
                String gender = resultSet.getString(6);
                String department = resultSet.getString(7);

                Employee employee = new Employee();
                employee.setId(e_id);
                employee.setFirstName(firstName);
                employee.setLastName(lastName);
                employee.setEmail(email);
                employee.setMobile(mobile);
                employee.setGender(gender);
                employee.setDepartment(department);

                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public Employee findById(Long id) {
        Employee employee = new Employee();
        String sql = "select *from employee where id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                Long e_id = resultSet.getLong(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String email = resultSet.getString(4);
                String mobile = resultSet.getString(5);
                String gender = resultSet.getString(6);
                String department = resultSet.getString(7);

                employee.setId(e_id);
                employee.setFirstName(firstName);
                employee.setLastName(lastName);
                employee.setEmail(email);
                employee.setMobile(mobile);
                employee.setGender(gender);
                employee.setDepartment(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void delete(Long id) {
        String sql = "delete from employee where id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1,id);
            int result = statement.executeUpdate();
            if (result > 0){
                System.out.println("deleted");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
