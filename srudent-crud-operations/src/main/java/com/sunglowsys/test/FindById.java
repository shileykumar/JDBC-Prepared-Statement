package com.sunglowsys.test;

import com.sunglowsys.domain.Student;
import com.sunglowsys.service.StudentService;
import com.sunglowsys.service.StudentServiceImpl;

public class FindById {
    private static void getById(StudentService studentService){
        Student student = studentService.findById(1L);
        System.out.println(student);
    }

    public static void main(String[] args) {
        StudentService studentService = new StudentServiceImpl();
        getById(studentService);
    }
}
