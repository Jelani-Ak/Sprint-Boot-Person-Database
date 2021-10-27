package com.example.demo.service;

import com.example.demo.dao.PersonDatabase;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    //Instantiating the interface
    private final PersonDatabase personDatabase;

    @Autowired //Injecting into the constructor ~ Autowiring into this interface
    public PersonService(@Qualifier("postgres") PersonDatabase personDao) { //@Qualifier allows for differentiation for multiple implementations
        this.personDatabase = personDao;
    }

    //Add a person to the database
    public int addPerson(Person person) {
        return personDatabase.insertPerson(person);
    }

    //Retrieve all people from the database
    public List<Person> getAllPeople() {
        return personDatabase.getAllPeople();
    }

    //Retrieve a specific person from the database
    public Optional<Person> getPersonByID(UUID id) {
        return personDatabase.getPersonByID(id);
    }

    //Delete a person from the database
    public int deletePerson(UUID id) {
        return personDatabase.deletePersonByID(id);
    }

    //Update a person from the database
    public int updatePerson(UUID id, Person newPerson) {
        return personDatabase.updatePersonByID(id, newPerson);
    }
}

