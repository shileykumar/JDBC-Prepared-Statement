package com.sunglowsys.service;

import com.sunglowsys.domain.Student;
import com.sunglowsys.repository.StudentRepository;
import com.sunglowsys.repository.StudentRepositoryImpl;

import java.util.List;

public class StudentServiceImpl implements StudentService{
    private StudentRepository studentRepository = new StudentRepositoryImpl();

    @Override
    public void save(Student student) {
        //TODO
        studentRepository.save(student);
    }

    @Override
    public void update(Student student) {
        studentRepository.update(student);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        studentRepository.delete(id);
    }
}
