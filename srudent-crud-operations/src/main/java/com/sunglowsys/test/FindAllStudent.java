package com.sunglowsys.test;

import com.sunglowsys.domain.Student;
import com.sunglowsys.repository.StudentRepository;
import com.sunglowsys.repository.StudentRepositoryImpl;
import com.sunglowsys.service.StudentService;
import com.sunglowsys.service.StudentServiceImpl;

import java.util.List;

public class FindAllStudent {
    public static void main(String[] args) {
        StudentService studentService = new StudentServiceImpl();
        findAllStudent(studentService);
    }
    private static void findAllStudent(StudentService studentService){
        List<Student> studentList = studentService.findAll();
        for (Student student:studentList){
            System.out.println(student);
        }
    }
}
