package com.attendancemanagementsystem.domains;


import com.attendancemanagementsystem.dto.PersonDTO;
import com.attendancemanagementsystem.dto.PersonUpdateDTO;
import com.attendancemanagementsystem.responsehandler.ResponseHandler;
import com.attendancemanagementsystem.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    PersonServices personServicesImpl;

    @PostMapping("/person/add")
    public ResponseEntity<Object> savePerson(@RequestBody PersonDTO personDTO) {
        Optional<PersonDTO> responsePersonDTO = Optional.ofNullable(personServicesImpl.savePerson(personDTO));
        return responsePersonDTO.map(person -> ResponseHandler.generateResponse("Successfully added Person ", HttpStatus.OK, person)).orElseGet(() -> ResponseHandler.generateResponse("Unsuccessful", HttpStatus.BAD_REQUEST, "Check request " + personDTO));
    }

    @GetMapping("/person/view/{id}")
    public ResponseEntity<Object> viewPersonById(@PathVariable(value = "id") Long id) {
        Optional<PersonDTO> responsePersonDTO = Optional.ofNullable(personServicesImpl.viewPerson(id));
        return responsePersonDTO.map(personDTO -> ResponseHandler.generateResponse("Below", HttpStatus.OK, personDTO)).orElseGet(() -> ResponseHandler.generateResponse("Could not find the below Id", HttpStatus.BAD_REQUEST, " Check id " + id));
    }

    @PutMapping("/person/update/{id}")
    public ResponseEntity<Object> updatePerson(@PathVariable(value = "id") Long id, @RequestBody PersonUpdateDTO personDTO) {
        Optional<PersonDTO> responsePersonDTO = Optional.ofNullable(personServicesImpl.updatePerson(id, personDTO));
        if (responsePersonDTO.isPresent()) {
            return ResponseHandler.generateResponse("Update Successful", HttpStatus.OK, responsePersonDTO.get());
        } else {
            return ResponseHandler.generateResponse("Update Unsuccessful", HttpStatus.BAD_REQUEST, "Check request " + personDTO.toString() + " Check id " + id);
        }
    }
}
