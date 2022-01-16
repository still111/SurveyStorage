package com.spring.SurveyStorage.dao;

import com.spring.SurveyStorage.entity.Question;


import java.util.List;

public interface QuestionDAO {

     void saveQuestion(int survey_id, Question question);


     List<Question> getAllQuestions();

     List<Question> getDetQuestions(int survey_id);

     Question getQuest(int id);

     void saveQuestion(Question question);

     void deleteQuest(int id);
}
