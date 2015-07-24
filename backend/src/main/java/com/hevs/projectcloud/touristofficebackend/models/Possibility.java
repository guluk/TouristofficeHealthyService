package com.hevs.projectcloud.touristofficebackend.models;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * Created by lukas_000 on 11.07.2015.
 * for Cloud-Project 645-2 HES-SO Valais
 */
@Entity
public class Possibility {

    @Id
    private Long id;

    private Text description;

    private int points;

    private Reply reply;

    public Possibility() { }

    public Long getPossibilityId() {
        return this.id;
    }

    public Text getDescription() {
        return this.description;
    }

    public void setDescription(Text description) {
        this.description = description;
    }

    public int getPoints(){
        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Reply getReply(){
        return this.reply;
    }

    public void setReply(Reply reply) {
        this.reply = reply;
    }
}
