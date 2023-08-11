package com.kspv.busapp.controller;

import com.kspv.kcgbus.model.Attendance;
import com.kspv.kcgbus.service.QrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/attendance")
public class QrAttendanceController {

    @Autowired
    private QrService qrService;


    public QrAttendanceController(QrService qrService)
    {
        super();
        this.qrService = qrService;
    }
    @PostMapping("save")
    public ResponseEntity<Attendance> saveQrAttendance(@RequestBody Attendance student)
    {
        if(qrService.saveStudent(student))
        {
            return new ResponseEntity<Attendance>(student, HttpStatus.CREATED);
        }
        return new ResponseEntity<Attendance>(student, HttpStatus.UNAUTHORIZED);
    }
}