package com.spring.My_Greeting_App.service;

import com.spring.My_Greeting_App.model.GreetingEntity;
import com.spring.My_Greeting_App.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.Optional;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    public String getGreetingMessage() {
        return "Hello World!";
    }

    public GreetingEntity saveGreetingMessage(String message) {
        GreetingEntity greeting = new GreetingEntity(message);
        return greetingRepository.save(greeting);
    }

    public GreetingEntity getGreetingById(Long id) {
        Optional<GreetingEntity> greeting = greetingRepository.findById(id);
        return greeting.orElseThrow(() -> new RuntimeException("Greeting not found with ID: " + id));
    }
}

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
