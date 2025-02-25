package com.spring.My_Greetin_App.controller;


import com.spring.My_Greetin_App.model.Greeting;
import com.spring.My_Greetin_App.model.GreetingEntity;
import com.spring.My_Greetin_App.model.UserDTO;
import com.spring.My_Greetin_App.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/greeting")
    public ResponseEntity<GreetingEntity> createGreeting(@RequestBody UserDTO user) {
        String message = generateGreetingMessage(user.getFirstName(), user.getLastName());
        GreetingEntity savedGreeting = greetingService.saveGreetingMessage(message);
        return ResponseEntity.status(201).body(savedGreeting);
    }

    @PutMapping("/greeting/{id}")
    public GreetingEntity updateGreeting(@PathVariable Long id, @RequestBody Greeting updatedGreeting) {
        return greetingService.updateGreeting(id, updatedGreeting.getMessage());
    }

    @DeleteMapping("/greeting/{id}")
    public ResponseEntity<String> deleteGreeting(@PathVariable Long id) {
        greetingService.deleteGreeting(id);
        return ResponseEntity.ok("Greeting with ID " + id + " has been deleted successfully.");
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