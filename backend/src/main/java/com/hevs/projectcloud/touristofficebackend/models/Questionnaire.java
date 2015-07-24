package com.hevs.projectcloud.touristofficebackend.models;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

import java.util.Date;
import java.util.List;

/**
 * Created by lukas_000 on 10.07.2015.
 * for Cloud-Project 645-2 HES-SO Valais
 */
@Entity
public class Questionnaire {

    @Id
    private Long id;

    private String credentials;

    private Date datetime;

    private List<Question> questions;

    public Questionnaire() {

    }

    public Long getQuestionnaireId() {
        return this.id;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    public String getCredentials() {
        return this.credentials;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Date getDatetime() {
        return this.datetime;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Question> getQuestions() {
        return this.questions;
    }
}
