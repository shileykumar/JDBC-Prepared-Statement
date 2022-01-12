package com.sunglowsys.employee.test;

import com.sunglowsys.employee.service.EmployeeServiceImpl;

public class DeleteEmployee {
    public static void main(String[] args) {
        new EmployeeServiceImpl().delete(2L);
    }
}
