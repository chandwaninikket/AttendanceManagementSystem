package com.attendancemanagementsystem.dto;

import com.attendancemanagementsystem.entities.PersonEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.data.annotation.CreatedDate;

public class AttendanceDTO {

    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long attendanceId;

    @CreatedDate
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String attendanceDateTime;

    public AttendanceDTO(long attendanceId, String attendanceDateTime) {
        this.attendanceId = attendanceId;
        this.attendanceDateTime = attendanceDateTime;
    }

    public AttendanceDTO() {
    }

    public long getAttendanceId() {
        return attendanceId;
    }

    public String getAttendanceDateTime() {
        return attendanceDateTime;
    }


    public void setAttendanceId(long attendanceId) {
        this.attendanceId = attendanceId;
    }

    public void setAttendanceDateTime(String attendanceDateTime) {
        this.attendanceDateTime = attendanceDateTime;
    }


    @Override
    public String toString() {
        return "AttendanceDTO{" +
                "attendanceId=" + attendanceId +
                ", attendanceDateTime='" + attendanceDateTime + '\'' +
                '}';
    }
}

