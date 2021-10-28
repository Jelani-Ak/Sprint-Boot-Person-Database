package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PersonDataAccessService_Two implements PersonDatabase {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDataAccessService_Two(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static Person mapRow(ResultSet resultSet, int i) throws SQLException {
        UUID personID = UUID.fromString(resultSet.getString("id"));
        String first_name = resultSet.getString("first_name");
        String second_name = resultSet.getString("second_name");
        String email_address = resultSet.getString("email_address");
        String mobile_number = resultSet.getString("mobile_number");
        Date date_of_birth = resultSet.getDate("date_of_birth");
        int age = resultSet.getInt("age");
        return new Person(personID, first_name, second_name, email_address, mobile_number, date_of_birth, age);
    }

    @Override
    public int insertPerson(UUID id, Person person) {
        return 0;
    }

    @Override
    public List<Person> getAllPeople() {
        final String sql = "SELECT id, first_name, second_name, email_address, mobile_number, date_of_birth, age FROM person";
        return jdbcTemplate.query(sql, PersonDataAccessService_Two::mapRow);
    }

    @Override
    public Optional<Person> getPersonByID(UUID id) {
        final String sql = "SELECT id, first_name, second_name, email_address, mobile_number, date_of_birth, age FROM person WHERE id = ?";
        Person person = jdbcTemplate.queryForObject(sql, new Object[]{id}, PersonDataAccessService_Two::mapRow);
        return Optional.ofNullable(person);
    }

    @Override
    public int deletePersonByID(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonByID(UUID id, Person person) {
        return 0;
    }
}
