package com.spring.My_Greeting_App.repository;

import com.spring.My_Greeting_App.model.GreetingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends JpaRepository<GreetingEntity, Long> {
}
