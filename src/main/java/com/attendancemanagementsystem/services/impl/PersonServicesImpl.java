package com.attendancemanagementsystem.services.impl;

import com.attendancemanagementsystem.dto.PersonDTO;
import com.attendancemanagementsystem.dto.PersonUpdateDTO;
import com.attendancemanagementsystem.entities.PersonEntity;
import com.attendancemanagementsystem.exceptionhandler.PersonNotFoundException;
import com.attendancemanagementsystem.repositories.PersonRepository;
import com.attendancemanagementsystem.services.PersonServices;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServicesImpl implements PersonServices {

    Logger logger = LogManager.getLogger(PersonServicesImpl.class);

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public PersonDTO savePerson(PersonDTO personDTO) {

        try {
            logger.info("before mapping personDTO to personEntity" + personDTO.toString());
            PersonEntity p = mapper.map(personDTO, PersonEntity.class);
            //BeanUtils.copyProperties(personDTO, p, "personId");
            logger.info("saving personEntity and mapping back to personDTO" + personDTO.toString());
            return mapper.map(personRepository.save(p), PersonDTO.class);
        } catch (Exception E){
            return null;
        }

    }

    @Override
    public PersonDTO viewPerson(Long id) {
        Optional<PersonEntity> byId = personRepository.findByPersonId(id);
        try {
            return byId.map(s -> mapper.map(s, PersonDTO.class)).orElseThrow(() -> new PersonNotFoundException("Person ID was not found in DB"));
        }
        catch (PersonNotFoundException e){
            return null;
        }
    }

    @Override
    public PersonDTO updatePerson(Long id, PersonUpdateDTO personUpdateDTO) {
        try {
            logger.info("Searching for person in DB" + id + personUpdateDTO.toString());
            PersonEntity p = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException("ID was not found in DB"));
            logger.info("Setting the following details" + personUpdateDTO.getJobType() + personUpdateDTO.getPersonAge());
            p.setJobType(personUpdateDTO.getJobType());
            p.setPersonAge(personUpdateDTO.getPersonAge());
            logger.info("Saving the person details " + p.toString());
            return mapper.map(personRepository.save(p), PersonDTO.class);
        } catch (PersonNotFoundException e) {
            return null;
        }
    }
}
