package com.attendancemanagementsystem.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

@Entity
public class PersonEntity extends Auditable<String>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long personId;
    @Column(name = "Name")
    private String personName;
    @Column(name = "Age")
    private String personAge;
    @Column(name = "Job")
    @NotNull
    private String jobType;

    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<AttendanceEntity> attendances;

    public PersonEntity() {

    }

    public PersonEntity(long personId, String personName, String personAge, @NotNull String jobType, Set<AttendanceEntity> attendances) {
        this.personId = personId;
        this.personName = personName;
        this.personAge = personAge;
        this.jobType = jobType;
        this.attendances = attendances;
    }

    public Set<AttendanceEntity> getAttendances() {
        return attendances;
    }

    public void setAttendances(Set<AttendanceEntity> attendances) {
        this.attendances = attendances;
    }

    @Override
    public String toString() {
        return "PersonEntity{" +
                "personId=" + personId +
                ", personName='" + personName + '\'' +
                ", personAge='" + personAge + '\'' +
                ", jobType='" + jobType + '\'' +
                '}';
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonAge() {
        return personAge;
    }

    public void setPersonAge(String personAge) {
        this.personAge = personAge;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }
}
