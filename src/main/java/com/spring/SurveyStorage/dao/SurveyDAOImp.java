package com.spring.SurveyStorage.dao;




import com.spring.SurveyStorage.entity.Survey;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class SurveyDAOImp implements SurveyDAO{
    private final EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    public SurveyDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Survey> getAllSurveys() {
        Session session = getSession();
        List<Survey> allSurveys  = session.createQuery("from Survey"
                , Survey.class).getResultList();
        return allSurveys;
    }

    @Override
    public void saveSurvey(Survey survey) {
        Session session = getSession();
        session.saveOrUpdate(survey);
    }

    @Override
    public Survey getSurvey(int id) {
        Session session =getSession();
        Survey survey =session.get(Survey.class,id);
        return survey;
    }

    @Override
    public void deleteSurvey(int id) {
        Session session = getSession();
        Query<Survey> query = session.createQuery("delete from Survey where id=:surveyId");
        query.setParameter("surveyId",id);
        query.executeUpdate();
    }

}
