package com.attendancemanagementsystem.services;

import com.attendancemanagementsystem.dto.PersonDTO;
import com.attendancemanagementsystem.dto.PersonUpdateDTO;

public interface PersonServices {

    public PersonDTO savePerson(PersonDTO personDTO);

    public PersonDTO viewPerson(Long id);

    public PersonDTO updatePerson(Long id, PersonUpdateDTO personUpdateDTO);
}
