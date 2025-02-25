package com.spring.My_Greetin_App.services;

import com.spring.My_Greetin_App.model.GreetingEntity;
import com.spring.My_Greetin_App.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



import org.springframework.stereotype.Service;


@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    public String getGreetingMessage() {
        return "Hello World!";
    }

    public List<GreetingEntity> getAllGreetings() {
        return greetingRepository.findAll();
    }

    public GreetingEntity saveGreetingMessage(String message) {
        GreetingEntity greeting = new GreetingEntity(message);
        return greetingRepository.save(greeting);
    }

    public GreetingEntity getGreetingById(Long id) {
        Optional<GreetingEntity> greeting = greetingRepository.findById(id);

    public String getGreetingMessage() {
        return "Hello World";

    }
}
