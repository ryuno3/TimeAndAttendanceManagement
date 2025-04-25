package com.example.TimeAndAttendanceManagement;

import java.time.LocalTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.TimeAndAttendanceManagement.infrastructure.InMemoryAttendanceRepository;
import com.example.TimeAndAttendanceManagement.service.AttendanceService;

import lombok.var;

@SpringBootApplication
public class TimeAndAttendanceManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimeAndAttendanceManagementApplication.class, args);

		var repository = new InMemoryAttendanceRepository();
		var service = new AttendanceService(repository);

		int employeeId = 1;

		// 出勤処理
		service.clockIn(employeeId, LocalTime.of(9, 0));

		// 退勤処理
		service.clockOut(employeeId, LocalTime.of(18, 30 ));

	}

}
