package com.kspv.kcgbus.dao;

import com.kspv.kcgbus.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepo extends JpaRepository<Attendance, Integer> {
}