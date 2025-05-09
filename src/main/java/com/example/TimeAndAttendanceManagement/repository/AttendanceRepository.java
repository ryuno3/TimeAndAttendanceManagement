package com.example.TimeAndAttendanceManagement.repository;

import java.time.LocalDate;
import java.util.List;

import com.example.TimeAndAttendanceManagement.domain.model.AttendanceRecord;

public interface AttendanceRepository {

    void save(AttendanceRecord record);
    AttendanceRecord findByEmployeeIdAndDate(int employeeId, LocalDate date);
    List<AttendanceRecord> findAllByEmployeeId(int employeeId);
}