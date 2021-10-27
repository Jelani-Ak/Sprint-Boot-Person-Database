package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDatabase {

    //Insert a person with a given ID
    int insertPerson(UUID id, Person person);

    //Insert a person with a random ID
    default int insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    //Retrieve all users in the database
    List<Person> getAllPeople();

    Optional<Person> getPersonByID(UUID id);

    int deletePersonByID(UUID id);

    int updatePersonByID(UUID id, Person person);


}
