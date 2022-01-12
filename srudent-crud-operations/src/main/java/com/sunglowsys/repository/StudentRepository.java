package com.sunglowsys.repository;

import com.sunglowsys.domain.Student;

import java.util.List;

/**
 *
 */
public interface StudentRepository {

    /**
     * Save Student data
     * @param student
     */
    void save(Student student);

    /**
     * Update Student
     * @param student
     */
    void update(Student student);

    List<Student> findAll();

    Student findById(Long id);

    void delete(Long id);
}
