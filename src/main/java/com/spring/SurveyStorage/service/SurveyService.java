package com.spring.SurveyStorage.service;

import com.spring.SurveyStorage.entity.Survey;

import java.util.List;

public interface SurveyService {
     List<Survey> getAllSurveys();
     void saveSurvey(Survey survey);
     Survey getSurvey(int id);
     void deleteSurvey(int id);
}
