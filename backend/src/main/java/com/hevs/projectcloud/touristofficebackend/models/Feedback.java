package com.hevs.projectcloud.touristofficebackend.models;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

import java.util.List;

/**
 * Created by lukas_000 on 11.07.2015.
 * for Cloud-Project 645-2 HES-SO Valais
 */
@Entity
public class Feedback {

    @Id
    private Long id;

    private String description;

    private List<Possibility> possibilities;

    private List<Answer> answers;

    public Feedback() { }

    public Long getFeedbackId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public List<Possibility> getPossibilities() {
        return this.possibilities;
    }

    public void setPossibilities(List<Possibility> possibilities) {
        this.possibilities = possibilities;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Answer> getAnswers() {
        return this.answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
