package com.attendancemanagementsystem.services;

import com.attendancemanagementsystem.dto.AttendanceDTO;
import com.attendancemanagementsystem.dto.PersonUpdateDTO;

import java.util.List;

public interface AttendanceServices {

    public AttendanceDTO addAttendance(Long studentId);

    public List<AttendanceDTO> viewAttendance(Long studentId);

    //public AttendanceDTO updateAttendance(AttendanceDTO attendanceDTO);
}
