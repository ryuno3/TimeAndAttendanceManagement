package com.example.TimeAndAttendanceManagement.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.TimeAndAttendanceManagement.domain.model.AttendanceRecord;
import com.example.TimeAndAttendanceManagement.service.AttendanceService;

import java.time.LocalTime;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService){
        this.attendanceService = attendanceService;
    }

    @PostMapping("/clock-in")
    public String clockIn(@RequestParam int employeeId) {

        attendanceService.clockIn(employeeId, LocalTime.now());
        return LocalTime.now() + "に出勤しました"; 
    }

    @PostMapping("/clock-out")
    public String clockOut(@RequestParam int employeeId) {

        attendanceService.clockOut(employeeId, LocalTime.now());
        return LocalTime.now().toString() + "に退勤しました"; 
    }
    
    @GetMapping("/today/{employeeId}")
    public AttendanceRecord getTodayAttendance(@PathVariable int employeeId) {
        return attendanceService.getTodayAttendance(employeeId);
    }
    
    
}
