package com.attendancemanagementsystem.dto;

import jakarta.persistence.Column;

public class PersonUpdateDTO {

    @Column(name = "Age")
    private String personAge;
    @Column(name = "Job")
    private String jobType;

    public PersonUpdateDTO(String personAge, String jobType) {
        this.personAge = personAge;
        this.jobType = jobType;
    }

    public PersonUpdateDTO() {
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

    @Override
    public String toString() {
        return "PersonUpdateDTO{" +
                "personAge='" + personAge + '\'' +
                ", jobType='" + jobType + '\'' +
                '}';
    }
}

