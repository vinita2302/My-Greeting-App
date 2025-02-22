package com.spring.My_Greetin_App.controller;

import com.spring.My_Greetin_App.model.Greeting;
import com.spring.My_Greetin_App.model.UserDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class GreetingController {

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