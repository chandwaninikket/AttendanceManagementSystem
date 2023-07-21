package com.attendancemanagementsystem.repositories;

import com.attendancemanagementsystem.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

    public Optional<PersonEntity> findByPersonId(Long id);

}
