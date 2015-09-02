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

    private String phoneNumber;

    private String languageCode;

    private Date datetime;

    private List<Question> questions;

    //LG/ Constructor
    public Questionnaire() {
        //LG/ default language is english
        this.languageCode = "en";
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

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getLanguageCode() {
        return this.languageCode;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Date getDatetime() {
        return this.datetime;
    }

    //TODO this is probably to change into "Feedback" instead of "Question"
    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    //TODO this is probably to change into "Feedback" instead of "Question"
    public List<Question> getQuestions() {
        return this.questions;
    }

    /**
     *
     * @param c the Category for which the result should be given in return
     * @return the total number of points (values of the possibilities) for this Category
     */
    public int calculateReplyResultPerCategory(Category c) {

        int result = 0;

        for(Question q : this.questions) {

            //LG/ if the category of the question matches the category given as argument
            //    the result is increased with the value of the checked replies
            if(q.getCategory() == c)
                result += q.calculateReplyResult();
        }

        return result;
    }
}
