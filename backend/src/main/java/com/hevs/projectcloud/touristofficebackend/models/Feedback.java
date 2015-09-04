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

    private Text description;

    private List<Possibility> possibilities;

    public Feedback() { }

    public Long getFeedbackId() {
        return this.id;
    }

    public Text getDescription() {
        return this.description;
    }

    public void setDescription(Text description) {
        this.description = description;
    }

    public List<Possibility> getPossibilities() {
        return this.possibilities;
    }

    public void setPossibilities(List<Possibility> possibilities) {
        this.possibilities = possibilities;
    }

    /**
     * //LG/ Calculates the result points for the feedback/question
     * @return the sum of the points of the possibilities that are checked
     */
    public int calculateReplyResult() {

        int result = 0;

        for (Possibility p : this.possibilities) {

            //LG/ if this option/possibility is checked, add the points of the possibility
            if (p.getReply().getValue() == true)
                result += p.getPoints();
        }

        return result;
    }

    /**
     * //LG/ Add another possibility to the feedback/question
     */
    public void addPossibility(Possibility possibility) {
        this.possibilities.add(possibility);
    }

}
