package com.example.TimeAndAttendanceManagement.service;

import java.time.LocalDate;
import java.time.LocalTime;

import com.example.TimeAndAttendanceManagement.domain.model.AttendanceRecord;
import com.example.TimeAndAttendanceManagement.repository.AttendanceRepository;

public class AttendanceService {
    private final AttendanceRepository repository;

    public AttendanceService(AttendanceRepository repository){
        this.repository = repository;
    }

    private AttendanceRecord getTodayRecord(int employeeId){
        LocalDate today = LocalDate.now();
        return repository.findByEmployeeIdAndDate(employeeId, today);
    }

    public void clockIn(int employeeId, LocalTime time){
        LocalDate today = LocalDate.now();
        AttendanceRecord record = new AttendanceRecord(employeeId, today);
        record.clockIn(time);
        repository.save(record);
        System.out.println("出勤完了！" + time);

    }

    public void clockOut(int employeeId, LocalTime time){
        AttendanceRecord record = getTodayRecord(employeeId);
        if (record != null) {
            record.clockOut(time);
            repository.save(record);
            System.out.println("退勤完了！" + time);
        }else{
            System.out.println("出勤記録が見つかりません");
        }
    }
}
