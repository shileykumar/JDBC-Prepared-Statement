package com.sunglowsys.test;

import com.sunglowsys.domain.Student;
import com.sunglowsys.service.StudentService;
import com.sunglowsys.service.StudentServiceImpl;

public class DeleteById {
    public static void main(String[] args) {
        StudentService studentService = new StudentServiceImpl();
        studentService.delete(1L);
    }
}
