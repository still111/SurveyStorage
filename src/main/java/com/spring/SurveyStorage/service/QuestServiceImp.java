package com.spring.SurveyStorage.service;

import com.spring.SurveyStorage.entity.Question;
import com.spring.SurveyStorage.entity.Survey;
import com.spring.SurveyStorage.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestServiceImp implements com.spring.SurveyStorage.service.QuestService {
    private final QuestionRepository questionRepository;
    private final SurveyServiceImpl surveyServiceImpl;

    public QuestServiceImp(QuestionRepository questionDAO, SurveyServiceImpl surveyServiceImpl) {
        this.questionRepository = questionDAO;
        this.surveyServiceImpl = surveyServiceImpl;
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public List<Question> getDetQuestion(int survey_id) {
        List<Question> optional = questionRepository.findAllBySurvey_id(survey_id);
        return optional;
    }

    @Override
    public void saveQuestion(int survey_id, Question question) {
        Survey survey = surveyServiceImpl.getSurvey(survey_id);
        if (question.getSurvey() == null) survey.addQuestToSurvey(question);
        surveyServiceImpl.saveSurvey(survey);
    }

    @Override
    public Question getQuest(int id) {
        Question question = null;
        Optional<Question> optional = questionRepository.findById(id);
        if (optional.isPresent()) {
            question = optional.get();
        }
        return question;
    }

    @Override
    public void deleteQuest(int id) {
        questionRepository.deleteById(id);
    }
}
