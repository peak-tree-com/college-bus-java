package com.kspv.kcgbus.service.Impl;

import com.kspv.kcgbus.dao.StudentRepo;
import com.kspv.kcgbus.exception.ResourceNotFoundException;
import com.kspv.kcgbus.model.Student;
import com.kspv.kcgbus.service.Admin;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements Admin {
    StudentRepo studentTable;
    public AdminServiceImpl(StudentRepo StudentTable) {
        this.studentTable = StudentTable;
    }
    @Override
    public Student saveStudent(Student student) {
        return studentTable.save(student);
    }
    @Override
    public List<Student> getAllStudent(){return studentTable.findAll(); }

    @Override
    public Student getStudent(int id) {
        return studentTable.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student","id",id));
    }

    @Override
    public Student updateStudent(int id, @NotNull Student student) {
        //check id exists
        Student existingStudent = studentTable.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student","id",id));

        existingStudent.setRollNo(student.getRollNo());
        existingStudent.setPassword(student.getPassword());
        return studentTable.save(existingStudent);
    }
    @Override
    public void deleteStudent(int id){
        studentTable.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student","id",id));
        studentTable.deleteById(id);
    }
}