package com.sunglowsys.employee.test;

import com.sunglowsys.employee.domain.Employee;
import com.sunglowsys.employee.service.EmployeeService;
import com.sunglowsys.employee.service.EmployeeServiceImpl;

public class CreateEmployee {
    public static void createEmployee(){
        Employee employee = new Employee();
        employee.setFirstName("shiley");
        employee.setLastName("kumar");
        employee.setEmail("shiley@gmail.com");
        employee.setMobile("972055653");
        employee.setGender("Male");
        employee.setDepartment("Development");
        new EmployeeServiceImpl().save(employee);
    }

    public static void main(String[] args) {
        createEmployee();
    }
}
