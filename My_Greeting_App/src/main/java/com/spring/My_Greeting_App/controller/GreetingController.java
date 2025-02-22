package com.spring.My_Greeting_App.controller;


import com.spring.My_Greeting_App.model.Greeting;
import com.spring.My_Greeting_App.model.UserDTO;
import com.spring.My_Greeting_App.service.GreetingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @PostMapping
    public Greeting getGreeting(@RequestBody(required = false) UserDTO user) {
        return greetingService.getGreeting(user);
    }
}
