package com.kspv.kcgbus.service.Impl;

import com.kspv.kcgbus.dao.AttendanceRepo;
import com.kspv.kcgbus.dao.StudentRepo;
import com.kspv.kcgbus.exception.ResourceNotFoundException;
import com.kspv.kcgbus.model.Attendance;
import com.kspv.kcgbus.model.Student;
import com.kspv.kcgbus.service.QrService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class QrServiceImpl implements QrService {

    StudentRepo studentTable;
    AttendanceRepo attendanceTable;
    QrServiceImpl(AttendanceRepo attendanceTable, StudentRepo studentTable){
        this.attendanceTable = attendanceTable;
        this.studentTable = studentTable;
    }
    @Override
    public boolean saveStudent(Attendance student) {
        if(checkPassword(student.getRollNo(), student.getPassword())){
            attendanceTable.save(student);
            logger.info("Authentication Successful for user {}", student.getRollNo());
            return true;
        }
        logger.error("Authentication failed for user {}", student.getRollNo());
        return false;
    }
    @Override
    public boolean checkPassword(int id, String confirmPassword) {
        Student existingStudent = studentTable.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Student","id",id)
        );
        String password = existingStudent.getPassword();
        return Objects.equals(confirmPassword, password);
    }
}

