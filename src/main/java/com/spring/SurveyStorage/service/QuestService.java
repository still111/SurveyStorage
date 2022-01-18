package com.spring.SurveyStorage.service;

import com.spring.SurveyStorage.entity.Question;

import java.util.List;

public interface QuestService {
     List<Question> getAllQuestions();
     List<Question> getDetQuestion(int survey_id);
     void saveQuestion(int survey_id, Question question);
     Question getQuest(int id);

    void deleteQuest(int id);
}
