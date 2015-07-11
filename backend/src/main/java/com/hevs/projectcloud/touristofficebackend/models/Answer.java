package com.hevs.projectcloud.touristofficebackend.models;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * Created by lukas_000 on 11.07.2015.
 */
@Entity
public class Answer {

    @Id
    private Long key;

    private Possibility possiblity;

    private int points;

    public Answer() {}

    public Possibility getPossiblity() {
        return this.possiblity;
    }

    public void setPossiblity_id(Possibility possiblity) {
        this.possiblity = possiblity;
    }

    public int getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
