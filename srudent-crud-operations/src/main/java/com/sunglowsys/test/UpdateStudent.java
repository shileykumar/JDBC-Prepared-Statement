package com.sunglowsys.test;

import com.sunglowsys.domain.Student;
import com.sunglowsys.service.StudentService;
import com.sunglowsys.service.StudentServiceImpl;

public class UpdateStudent {
    private static void updateStudent(){
        Student student = new Student();
        student.setEmail("shileykumar@gmail.com");
        student.setId(1L);
        new StudentServiceImpl().update(student);
    }

    public static void main(String[] args) {

        updateStudent();
    }
}
