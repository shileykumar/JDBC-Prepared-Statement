package com.sunglowsys.employee.test;

import com.sunglowsys.employee.domain.Employee;
import com.sunglowsys.employee.service.EmployeeServiceImpl;

public class UpdateEmployee {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setEmail("Development");
        employee.setId(1l);
        new EmployeeServiceImpl().update(employee);
    }
}
