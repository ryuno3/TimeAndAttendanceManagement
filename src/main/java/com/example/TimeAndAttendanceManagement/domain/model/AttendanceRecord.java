package com.example.TimeAndAttendanceManagement.domain.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class AttendanceRecord {
    private final int employeeId;
    private final LocalDate date;
    private LocalTime clockInTime;
    private LocalTime clockOutTime;

    public AttendanceRecord(int employeeId, LocalDate date) {
        this.employeeId = employeeId;
        this.date = date;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getClockInTime() {
        return clockInTime;
    }

    public LocalTime getClockOutTime(){
        return clockOutTime;
    }

    public void clockIn(LocalTime time){
        this.clockInTime = time; 
    }

    public void clockOut(LocalTime time){
        this.clockOutTime = time;
    }

}
