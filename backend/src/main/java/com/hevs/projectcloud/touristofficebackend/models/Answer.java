package com.hevs.projectcloud.touristofficebackend.models;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * Created by lukas_000 on 11.07.2015.
 * for Cloud-Project 645-2 HES-SO Valais
 */
@Entity
public class Answer {

    @Id
    private Long id;

    private Possibility possibility;

    private int points;

    public Answer() {}

    public Long getAnswerId() {
        return this.id;
    }

    public Possibility getPossibility() {
        return this.possibility;
    }

    public void setPossibility(Possibility possibility) {
        this.possibility = possibility;
    }

    public int getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
