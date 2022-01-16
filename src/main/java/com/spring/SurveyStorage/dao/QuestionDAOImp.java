package com.spring.SurveyStorage.dao;


import com.spring.SurveyStorage.entity.Question;
import com.spring.SurveyStorage.entity.Survey;


import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import java.util.List;

@Repository
public class QuestionDAOImp implements QuestionDAO {
    private final EntityManager entityManager;

    public QuestionDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }



    @Override
    public List<Question> getAllQuestions() {
        Session session = getSession();
        List<Question> questions = session.createQuery("from Question"
                , Question.class).getResultList();
        return questions;

    }

    @Override
    public List<Question> getDetQuestions(int survey_id){
        Session session = getSession();
        List<Question> questions= session.createQuery(
                "from Question where survey_id ='"+survey_id+"'"
                , Question.class).getResultList();
        return questions;
    }

    @Override
    public Question getQuest(int id) {
        Session session = getSession();
        Question question = session.get(Question.class, id);
        return question;
    }

    @Override
    public void saveQuestion(Question question) {
        Session session = getSession();
        session.saveOrUpdate(question);
    }

    @Override
    public void deleteQuest(int id) {
        Session session = getSession();
        Query<Question> query = session.createQuery("delete from Question where id=:questId");
        query.setParameter("questId",id);
        query.executeUpdate();
    }

    @Override
    public void saveQuestion(int survey_id, Question question) {
        Session session = getSession();
        Survey survey = session.get(Survey.class,survey_id);
        if (question.getSurvey()==null)survey.addQusettoSurvey(question);
        session.save(question);
    }


}
