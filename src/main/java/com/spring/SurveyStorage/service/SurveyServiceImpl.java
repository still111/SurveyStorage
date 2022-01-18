package com.spring.SurveyStorage.service;

import com.spring.SurveyStorage.entity.Survey;
import com.spring.SurveyStorage.repository.SurveyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyServiceImpl implements com.spring.SurveyStorage.service.SurveyService {
    private final SurveyRepository surveyRepository;

    public SurveyServiceImpl(SurveyRepository surveyDAO) {
        this.surveyRepository = surveyDAO;
    }

    @Override
    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    @Override
    public void saveSurvey(Survey survey) {
        surveyRepository.save(survey);
    }

    @Override
    public Survey getSurvey(int id) {
        Survey survey = null;
        Optional<Survey> optional = surveyRepository.findById(id);
        if (optional.isPresent()) {
            survey = optional.get();
        }
        return survey;
    }

    @Override
    public void deleteSurvey(int id) {
        surveyRepository.deleteById(id);
    }

}
