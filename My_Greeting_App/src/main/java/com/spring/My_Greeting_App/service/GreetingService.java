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
}
