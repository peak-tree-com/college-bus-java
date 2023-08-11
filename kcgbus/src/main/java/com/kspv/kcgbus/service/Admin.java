package com.kspv.kcgbus.service;

import com.kspv.kcgbus.model.Student;

import java.util.List;

public interface Admin {
    Student saveStudent(Student student);
    List<Student> getAllStudent();
    Student getStudent(int id);
    Student updateStudent(int id, Student student);
    void deleteStudent(int id);
}