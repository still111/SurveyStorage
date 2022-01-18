package com.spring.SurveyStorage.repository;


import com.spring.SurveyStorage.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActUserRepository extends JpaRepository<User, Integer> {
}
