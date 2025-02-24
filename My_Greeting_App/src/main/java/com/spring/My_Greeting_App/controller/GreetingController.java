package com.spring.My_Greeting_App.controller;



import com.spring.My_Greeting_App.model.Greeting;
import com.spring.My_Greeting_App.model.GreetingEntity;
import com.spring.My_Greeting_App.model.UserDTO;
import com.spring.My_Greeting_App.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/greeting/{id}")
    public GreetingEntity getGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }

    @PostMapping("/greeting")
    public ResponseEntity<GreetingEntity> createGreeting(@RequestBody UserDTO user) {
        String message = generateGreetingMessage(user.getFirstName(), user.getLastName());
        GreetingEntity savedGreeting = greetingService.saveGreetingMessage(message);
        return ResponseEntity.status(201).body(savedGreeting);
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