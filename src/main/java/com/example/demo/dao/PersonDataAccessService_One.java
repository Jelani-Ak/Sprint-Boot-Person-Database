package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao") //Annotation to tell the class to be instantiated as a bean. Can use @Component as well
public class PersonDataAccessService_One implements PersonDatabase {

    private static final List<Person> database = new ArrayList<>();

    @Override //Add a person to the database
    public int insertPerson(UUID id, Person person) {
        database.add(new Person(
                id,
                person.getFirst_name(),
                person.getSecond_name(),
                person.getEmail_address(),
                person.getMobile_number()));
        return 1;
    }

    @Override
    public List<Person> getAllPeople() {
        return database;
    }

    @Override
    public Optional<Person> getPersonByID(UUID id) {
        return database.stream()
                .filter(Person -> Person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePersonByID(UUID id) {
        Optional<Person> person = getPersonByID(id);
        if (person.isEmpty()) {
            return 0;
        }

        database.remove(person.get());
        return 1;
    }

    @Override
    public int updatePersonByID(UUID id, Person update) {
        return getPersonByID(id)
                .map(person -> {
                    int indexOfPersonToUpdate = database.indexOf(person);
                    if (indexOfPersonToUpdate >= 0) {
                        database.set(indexOfPersonToUpdate, new Person(
                                id,
                                update.getFirst_name(),
                                update.getSecond_name(),
                                update.getEmail_address(),
                                update.getMobile_number()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
