package com.attendancemanagementsystem.repositories;

import com.attendancemanagementsystem.dto.AttendanceDTO;
import com.attendancemanagementsystem.entities.AttendanceEntity;
import com.attendancemanagementsystem.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<AttendanceEntity, Long> {

    public List<AttendanceEntity> findByPerson(PersonEntity p);
}
