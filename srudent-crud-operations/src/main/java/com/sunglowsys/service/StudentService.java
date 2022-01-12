package com.sunglowsys.service;

import com.sunglowsys.domain.Student;

import java.util.List;

public interface StudentService {

    void save(Student student);

    void update(Student student);

    List<Student> findAll();

    Student findById(Long id);

    void delete(Long id);
}
