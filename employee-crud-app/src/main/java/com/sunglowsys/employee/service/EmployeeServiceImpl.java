package com.sunglowsys.employee.service;

import com.sunglowsys.employee.domain.Employee;
import com.sunglowsys.employee.repository.EmployeeRepository;
import com.sunglowsys.employee.repository.EmployeeRepositoryImpl;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{
    EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.update(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.delete(id);
    }
}
