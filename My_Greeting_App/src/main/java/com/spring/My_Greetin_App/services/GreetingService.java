package com.spring.My_Greetin_App.services;



import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public String getGreetingMessage() {
        return "Hello World";
    }
}
