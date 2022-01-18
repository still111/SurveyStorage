package com.spring.SurveyStorage.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "text")
    private String text;
    @Column(name = "type")
    private String type;
    @Column(name = "var1")
    private String var1;
    @Column(name = "var2")
    private String var2;
    @Column(name = "var3")
    private String var3;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "survey_id", nullable = false)
    private Survey survey;

}
