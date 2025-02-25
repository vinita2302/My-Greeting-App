package com.spring.My_Greetin_App.repository;


import com.spring.My_Greetin_App.model.Greeting;
import com.spring.My_Greetin_App.model.GreetingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends JpaRepository<GreetingEntity, Long> {
}