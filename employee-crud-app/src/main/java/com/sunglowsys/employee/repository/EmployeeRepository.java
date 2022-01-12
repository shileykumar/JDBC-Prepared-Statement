package com.sunglowsys.employee.repository;

import com.sunglowsys.employee.domain.Employee;

import java.util.List;

public interface EmployeeRepository {
    void save(Employee employee);
    void update(Employee employee);
    List<Employee> findAll();
    Employee findById(Long id);
    void delete(Long id);
}
