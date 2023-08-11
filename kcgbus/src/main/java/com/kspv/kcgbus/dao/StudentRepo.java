package com.kspv.kcgbus.dao;

import com.kspv.kcgbus.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {
}