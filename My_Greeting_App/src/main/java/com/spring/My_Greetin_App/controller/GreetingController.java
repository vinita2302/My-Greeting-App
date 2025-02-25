package com.spring.My_Greetin_App.controller;

import com.spring.My_Greetin_App.model.Greeting;


import com.spring.My_Greetin_App.model.GreetingEntity;
import com.spring.My_Greetin_App.model.UserDTO;
import com.spring.My_Greetin_App.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.spring.My_Greetin_App.model.UserDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/greeting")
    public ResponseEntity<Greeting> getGreeting() {
        return ResponseEntity.ok(new Greeting(greetingService.getGreetingMessage()));
    }

    @GetMapping("/greetings")
    public List<GreetingEntity> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    @GetMapping("/greeting/{id}")
    public ResponseEntity<GreetingEntity> getGreetingById(@PathVariable Long id) {
        GreetingEntity greeting = greetingService.getGreetingById(id);
        return ResponseEntity.ok(greeting);
    }

    @PostMapping("/greeting")
    public ResponseEntity<GreetingEntity> createGreeting(@RequestBody UserDTO user) {
        String message = generateGreetingMessage(user.getFirstName(), user.getLastName());
        GreetingEntity savedGreeting = greetingService.saveGreetingMessage(message);
        return ResponseEntity.status(201).body(savedGreeting);
    }


    @PutMapping("/greeting/{id}")
    public ResponseEntity<GreetingEntity> updateGreeting(@PathVariable Long id, @RequestBody Greeting updatedGreeting) {
        GreetingEntity updatedEntity = greetingService.updateGreeting(id, updatedGreeting.getMessage());
        return ResponseEntity.ok(updatedEntity);
    }

    private String generateGreetingMessage(String firstName, String lastName) {
        if (firstName != null && !firstName.isEmpty() && lastName != null && !lastName.isEmpty()) {
            return "Hello " + firstName + " " + lastName + " from BridgeLabz!";
        } else if (firstName != null && !firstName.isEmpty()) {
            return "Hello " + firstName + " from BridgeLabz!";
        } else if (lastName != null && !lastName.isEmpty()) {
            return "Hello " + lastName + " from BridgeLabz!";
        } else {
            return "Hello World!";
        }
    }
}


    @GetMapping("/greeting")
    public Greeting getGreeting() {
        return new Greeting("Hello from BridgeLabz!");
    }

    @PostMapping("/greeting")
    public Greeting createGreeting(@RequestBody UserDTO user) {
        return new Greeting("Hello " + user.getFirstName() + " " + user.getLastName() + " from BridgeLabz!");
    }

    @PutMapping("/greeting")
    public Greeting updateGreeting(@RequestBody UserDTO user) {
        return new Greeting("Updated greeting for " + user.getFirstName() + " " + user.getLastName());
    }

    @DeleteMapping("/greeting")
    public Greeting deleteGreeting() {
        return new Greeting("Greeting deleted successfully.");
    }
}

