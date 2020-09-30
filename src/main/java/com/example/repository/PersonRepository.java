package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.Person;

import java.util.List;

/**
 * @author Grzegorz Nowakowski
 */


public interface PersonRepository extends JpaRepository<Person, Long> {

    @Override
    List<Person> findAll();

    @Override
    Person save(Person entity);

    @Override
    void delete(Long id);
    Person findById(Long id);

}
