package com.attendancemanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories
public class AttendanceManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(AttendanceManagementSystemApplication.class, args);
    }

}
