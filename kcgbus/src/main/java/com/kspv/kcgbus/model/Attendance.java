package com.kspv.kcgbus.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jdk.jfr.Timestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Attendance {
    @Id
    private int rollNo;
    private String busRoute;
    private String password;
    @Transient
    @Column(name="ts", columnDefinition="TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP")
    private Date timestamp;
    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }
    public String getBusRoute() {
        return busRoute;
    }
    public void setBusRoute(String busRoute) {
        this.busRoute = busRoute;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Attendance(int rollNo, String busRoute, String password, Date timestamp) {
        this.rollNo = rollNo;
        this.busRoute = busRoute;
        this.password = password;
        this.timestamp = timestamp;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Attendance() {
    }
}