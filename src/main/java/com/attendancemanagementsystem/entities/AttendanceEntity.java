package com.attendancemanagementsystem.entities;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(
        uniqueConstraints=
        @UniqueConstraint(columnNames={"attendance_date_time", "person_id"})
)
public class AttendanceEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long attendanceId;

    @CreatedDate
    @Temporal(value=TemporalType.DATE)
    @Column(name="attendance_date_time")
    private LocalDate attendanceDateTime;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_id", nullable = false)
    private PersonEntity person;


        public AttendanceEntity(long attendanceId, LocalDate attendanceDateTime, PersonEntity person) {
            this.attendanceId = attendanceId;
            this.attendanceDateTime = attendanceDateTime;
            this.person = person;
        }

        public AttendanceEntity() {
        }

        public long getAttendanceId() {
            return attendanceId;
        }

        public LocalDate getAttendanceDateTime() {
            return attendanceDateTime;
        }

        public PersonEntity getPerson() {
            return person;
        }

        public void setAttendanceId(long attendanceId) {
            this.attendanceId = attendanceId;
        }

        public void setAttendanceDateTime(LocalDate attendanceDateTime) {
            this.attendanceDateTime = attendanceDateTime;
        }

        public void setPerson(PersonEntity person) {
            this.person = person;
        }
}
