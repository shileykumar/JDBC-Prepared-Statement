package com.sunglowsys.employee.test;

import com.sunglowsys.employee.domain.Employee;
import com.sunglowsys.employee.service.EmployeeService;
import com.sunglowsys.employee.service.EmployeeServiceImpl;

import java.util.List;

public class FindAllEmployee {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeServiceImpl();
        List<Employee> employeeList = employeeService.findAll();
        for (Employee employee : employeeList){
            System.out.println(employee);
        }
    }
}
