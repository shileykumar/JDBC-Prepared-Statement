package com.sunglowsys.test;

import com.sunglowsys.domain.Student;
import com.sunglowsys.service.StudentServiceImpl;

public class SaveStudentTest {

    public static void main(String[] args) {
        Student student = new Student();
        student.setFirstName("emma");
        student.setLastName("smith");
        student.setEmail("emma@gmail.com");
        student.setMobile("9720556533");
        student.setGender("Female");
        student.setSection("A");
        student.setDob("07/03/1997");

        new StudentServiceImpl().save(student);
    }
}
