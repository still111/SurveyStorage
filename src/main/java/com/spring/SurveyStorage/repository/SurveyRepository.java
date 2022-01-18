package com.spring.SurveyStorage.repository;


import com.spring.SurveyStorage.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SurveyRepository extends JpaRepository<Survey, Integer> {
}
