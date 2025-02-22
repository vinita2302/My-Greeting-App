package com.spring.My_Greeting_App.service;


import com.spring.My_Greeting_App.model.Greeting;
import com.spring.My_Greeting_App.model.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public Greeting getGreeting(UserDTO user) {
        if (user == null || (user.getFirstName() == null && user.getLastName() == null)) {
            return new Greeting("Hello World");
        } else if (user.getFirstName() != null && user.getLastName() != null) {
            return new Greeting("Hello " + user.getFirstName() + " " + user.getLastName());
        } else if (user.getFirstName() != null) {
            return new Greeting("Hello " + user.getFirstName());
        } else {
            return new Greeting("Hello " + user.getLastName());
        }
    }
}
