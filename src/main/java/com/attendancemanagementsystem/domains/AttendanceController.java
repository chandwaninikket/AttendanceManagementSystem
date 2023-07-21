package com.attendancemanagementsystem.domains;


import com.attendancemanagementsystem.dto.AttendanceDTO;
import com.attendancemanagementsystem.responsehandler.ResponseHandler;
import com.attendancemanagementsystem.services.AttendanceServices;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AttendanceController {

    Logger logger = LogManager.getLogger(AttendanceController.class);

    @Autowired
    AttendanceServices attendanceServices;

    @PostMapping("/attendance/{studentId}/add/")
    public ResponseEntity<Object> addAttendance(@PathVariable(name = "studentId") long studentId, @RequestBody AttendanceDTO attendanceDTO) {
        Optional<AttendanceDTO> attendanceResponseDTO = Optional.ofNullable(attendanceServices.addAttendance(studentId));
        return attendanceResponseDTO.map(attendance -> ResponseHandler.generateResponse("Successfully added Person ", HttpStatus.OK, attendance)).orElseGet(() -> ResponseHandler.generateResponse("Unsuccessful", HttpStatus.BAD_REQUEST, "Check request " + studentId));
    }

    @GetMapping("/attendance/{studentId}/view/")
    public ResponseEntity<Object> viewAttendance(@PathVariable(name = "studentId") long studentId) {
        Optional<List<AttendanceDTO>> attendanceResponseDTO = Optional.ofNullable(attendanceServices.viewAttendance(studentId));
        logger.info(attendanceResponseDTO);
        return attendanceResponseDTO.map(attendance -> ResponseHandler.generateResponse("Viewing person ", HttpStatus.OK, attendance.toString())).orElseGet(() -> ResponseHandler.generateResponse("Unsuccessful", HttpStatus.BAD_REQUEST, "Check request " + studentId));
    }
}
