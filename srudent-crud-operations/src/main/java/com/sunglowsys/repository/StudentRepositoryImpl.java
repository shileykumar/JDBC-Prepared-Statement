package com.sunglowsys.repository;

import com.sunglowsys.db.DatabaseConnection;
import com.sunglowsys.domain.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository{
    private Connection connection = DatabaseConnection.getConnection();

    @Override
    public void save(Student student) {
        String sql = "insert into students(first_name, last_name,email, mobile, gender, section, dob) values(?,?,?,?,?,?,?) ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,student.getFirstName());
            statement.setString(2,student.getLastName());
            statement.setString(3,student.getEmail());
            statement.setString(4,student.getMobile());
            statement.setString(5,student.getGender());
            statement.setString(6,student.getSection());
            statement.setString(7,student.getDob());

            int result = statement.executeUpdate();
            if(result>0){
                System.out.println("done--");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Student student) {
        String sql = "update students set email = ? where id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,student.getEmail());
            statement.setLong(2,student.getId());
            int result = statement.executeUpdate();
            if(result>0){
                System.out.println("updated-----");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Student> findAll() {
        String sql = "select *from students";
        List<Student> studentList = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Long s_id = resultSet.getLong(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String email = resultSet.getString(4);
                String mobile = resultSet.getString(5);
                String gender = resultSet.getString(6);
                String section = resultSet.getString(7);
                String dob = resultSet.getString(8);

                Student student = new Student();

                student.setId(s_id);
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setEmail(email);
                student.setMobile(mobile);
                student.setGender(gender);
                student.setSection(section);
                student.setDob(dob);

                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public Student findById(Long id) {
        Student student = new Student();
        String sql = "select *from students where id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                Long sId = resultSet.getLong(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String email = resultSet.getString(4);
                String mobile = resultSet.getString(5);
                String gender = resultSet.getString(6);
                String section = resultSet.getString(7);
                String dob = resultSet.getString(8);


                student.setId(sId);
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setEmail(email);
                student.setMobile(mobile);
                student.setGender(gender);
                student.setSection(section);
                student.setDob(dob);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public void delete(Long id) {
        String sql = "delete from students where id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1,id);
            int result = statement.executeUpdate();
            if(result > 0){
                System.out.println("deleted----");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
