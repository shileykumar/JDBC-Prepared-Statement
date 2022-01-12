package com.sunglowsys.employee.test;

import com.sunglowsys.employee.domain.Employee;
import com.sunglowsys.employee.service.EmployeeServiceImpl;

public class FindById {
    public static void main(String[] args) {
        Employee employee = new EmployeeServiceImpl().findById(1L);
        System.out.println(employee);
    }
}
