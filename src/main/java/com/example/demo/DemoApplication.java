package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    //GET is for retrieving data (@GetMapping)
    //POST is for adding a resource (@PostMapping)
    //PUT is for modifying data (@PutMapping)
    //DELETE for deleting a resource (@DeleteMapping)
}
