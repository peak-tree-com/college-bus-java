package com.kspv.kcgbus.service;

import com.kspv.kcgbus.model.Attendance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface QrService {
    static final Logger logger = LoggerFactory.getLogger("com.kspv.busapp");
    boolean saveStudent(Attendance student);
    boolean checkPassword(int rollNo, String password);
}