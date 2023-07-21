package com.attendancemanagementsystem.services.impl;

import com.attendancemanagementsystem.dto.AttendanceDTO;
import com.attendancemanagementsystem.entities.AttendanceEntity;
import com.attendancemanagementsystem.entities.PersonEntity;
import com.attendancemanagementsystem.exceptionhandler.PersonNotFoundException;
import com.attendancemanagementsystem.repositories.AttendanceRepository;
import com.attendancemanagementsystem.repositories.PersonRepository;
import com.attendancemanagementsystem.services.AttendanceServices;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AttendanceServicesImpl implements AttendanceServices {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    AttendanceRepository attendanceRepository;

    Logger logger = LogManager.getLogger(AttendanceServicesImpl.class);

    @Autowired
    ModelMapper mapper;

    @Override
    public AttendanceDTO addAttendance(Long studentId) {
        try {
            AttendanceEntity attendance = new AttendanceEntity();
            Optional<PersonEntity> personEntity = Optional.ofNullable(personRepository.findByPersonId(studentId).orElseThrow(() -> new PersonNotFoundException("Person ID was not found in DB")));
            attendance.setPerson(personEntity.get());
            attendanceRepository.save(attendance);
            return mapper.map(attendance, AttendanceDTO.class);
        } catch (Exception E) {
            logger.error("While marking attendance error faced " + E.getMessage());
            return null;
        }
    }

    @Override
    public List<AttendanceDTO> viewAttendance(Long studentId) {
        try {
            Type listType = new TypeToken<List<AttendanceDTO>>(){}.getType();
            Optional<PersonEntity> personEntity = Optional.ofNullable(personRepository.findByPersonId(studentId).orElseThrow(() -> new PersonNotFoundException("Person ID was not found in DB")));
            List<AttendanceDTO> attendanceDtoResponse = mapper.map(attendanceRepository.findByPerson(personEntity.get()), listType);
            return attendanceDtoResponse;
        } catch (Exception E) {
            logger.error("While viewing attendance error faced " + E.getMessage());
            return null;
        }
    }
}
