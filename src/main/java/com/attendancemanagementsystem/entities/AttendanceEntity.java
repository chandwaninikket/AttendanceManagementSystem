package com.attendancemanagementsystem.entities;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class AttendanceEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long attendanceId;

    @CreatedDate
    private String attendanceDateTime;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_id", nullable = false)
    private PersonEntity person;


        public AttendanceEntity(long attendanceId, String attendanceDateTime, PersonEntity person) {
            this.attendanceId = attendanceId;
            this.attendanceDateTime = attendanceDateTime;
            this.person = person;
        }

        public AttendanceEntity() {
        }

        public long getAttendanceId() {
            return attendanceId;
        }

        public String getAttendanceDateTime() {
            return attendanceDateTime;
        }

        public PersonEntity getPerson() {
            return person;
        }

        public void setAttendanceId(long attendanceId) {
            this.attendanceId = attendanceId;
        }

        public void setAttendanceDateTime(String attendanceDateTime) {
            this.attendanceDateTime = attendanceDateTime;
        }

        public void setPerson(PersonEntity person) {
            this.person = person;
        }
}
