package com.example.TimeAndAttendanceManagement.infrastructure;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.example.TimeAndAttendanceManagement.domain.model.AttendanceRecord;
import com.example.TimeAndAttendanceManagement.repository.AttendanceRepository;

public class InMemoryAttendanceRepository implements AttendanceRepository {
    private final Map<String, AttendanceRecord> storage = new HashMap<>();

    private String generateKey(int employeeId, LocalDate date){
        return employeeId + "_" + date.toString();
    }

    @Override
    public void save(AttendanceRecord record){
        String key = generateKey(record.getEmployeeId(), record.getDate());
        storage.put(key, record);
    }

    @Override
    public AttendanceRecord findByEmployeeIdAndDate(int employeeId, LocalDate date){
       return storage.get(generateKey(employeeId, date));
    }
}
