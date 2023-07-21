package com.attendancemanagementsystem.exceptionhandler;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends Exception {
    Logger logger = LogManager.getLogger(PersonNotFoundException.class);
    public PersonNotFoundException(String s){
        super(s);
        logger.error("Person Not Found Exception");
    }
}
