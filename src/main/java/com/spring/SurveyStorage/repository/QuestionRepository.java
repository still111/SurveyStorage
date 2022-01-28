package com.spring.SurveyStorage.repository;

import com.spring.SurveyStorage.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findAllBySurvey_id(Long survey_id);
}
