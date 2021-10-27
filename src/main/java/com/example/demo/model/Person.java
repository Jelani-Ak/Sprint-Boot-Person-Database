package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class Person {
    private final UUID id;

    @NotBlank
    private final String first_name;

    @NotBlank
    private final String second_name;
    private final String email_address;
    private final String mobile_number;

    //Constructor with everything
    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty("first_name") String first_name,
                  @JsonProperty("second_name") String second_name,
                  @JsonProperty("email_address") String email_address,
                  @JsonProperty("mobile_number") String mobile_number) {
        this.id = id;
        this.first_name = first_name;
        this.second_name = second_name;
        this.email_address = email_address;
        this.mobile_number = mobile_number;
    }

    public UUID getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public String getEmail_address() {
        return email_address;
    }

    public String getMobile_number() {
        return mobile_number;
    }
}
