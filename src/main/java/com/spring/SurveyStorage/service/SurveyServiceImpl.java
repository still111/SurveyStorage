package com.spring.SurveyStorage.service;

import com.spring.SurveyStorage.dao.SurveyDAO;
import com.spring.SurveyStorage.entity.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SurveyServiceImpl  implements com.spring.SurveyStorage.service.SurveyService {
    private final SurveyDAO surveyDAO;

    public SurveyServiceImpl(SurveyDAO surveyDAO) {
        this.surveyDAO = surveyDAO;
    }

    @Override
    @Transactional
    public List<Survey> getAllSurveys() {
        return surveyDAO.getAllSurveys();
    }

    @Override
    @Transactional
    public void saveSurvey(Survey survey) {surveyDAO.saveSurvey(survey);}

    @Override
    @Transactional
    public Survey getSurvey(int id) {
        return surveyDAO.getSurvey(id);
    }

    @Override
    @Transactional
    public void deleteSurvey(int id) {
        surveyDAO.deleteSurvey(id);
    }

}
