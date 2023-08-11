package com.kspv.kcgbus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Student {

    @Id
    private int rollNo;
    private String password;
    private String busRoute;

    public Student() {
    }

    public Student(int rollNo, String password, String busRoute) {
        this.rollNo = rollNo;
        this.password = password;
        this.busRoute = busRoute;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String dob) {
        this.password = dob;
    }

    public String getBusRoute() {
        return busRoute;
    }

    public void setBusRoute(String busRoute) {
        this.busRoute = busRoute;
    }
}