package com.attendancemanagementsystem.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class PersonDTO {


    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long personId;
    @Column(name = "Name")
    private String personName;
    @Column(name = "Age")
    private String personAge;
    @Column(name = "Job")
    private String jobType;

    public PersonDTO(String personName, String personAge, String jobType, Long personId) {
        this.personAge = personAge;
        this.jobType = jobType;
        this.personName = personName;
        this.personId = personId;
    }

    public PersonDTO() {
    }

    public long getPersonId() {
        return personId;
    }

    @JsonIgnore
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

    @Override
    public String toString() {
        return "PersonDTO{" +
                "personId=" + personId +
                ", personName='" + personName + '\'' +
                ", personAge='" + personAge + '\'' +
                ", jobType='" + jobType + '\'' +
                '}';
    }
}
