package com.spring.SurveyStorage.service;

import com.spring.SurveyStorage.dao.QuestionDAO;
import com.spring.SurveyStorage.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuestServiceImp implements com.spring.SurveyStorage.service.QuestService {
    private final QuestionDAO questionDAO;

    public QuestServiceImp(QuestionDAO questionDAO) {
        this.questionDAO = questionDAO;
    }

    @Override
    @Transactional
    public List<Question> getAllQuestions() {
        return questionDAO.getAllQuestions();
    }

    @Override
    @Transactional
    public List<Question> getDetQuestion(int survey_id) {
        return questionDAO.getDetQuestions(survey_id);
    }

    @Override
    @Transactional
    public void saveQuestion(int survey_id, Question question) {
       questionDAO.saveQuestion(survey_id,question);
    }

    @Override
    @Transactional
    public Question getQuest(int id) {
      return questionDAO.getQuest(id);
    }

    @Override
    @Transactional

    public void saveQuestion(Question question) {
        questionDAO.saveQuestion(question);
    }

    @Override
    @Transactional
    public void deleteQuest(int id) {questionDAO.deleteQuest(id);}
}
