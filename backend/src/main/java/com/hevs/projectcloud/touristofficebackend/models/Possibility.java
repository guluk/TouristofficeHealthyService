package com.hevs.projectcloud.touristofficebackend.models;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * Created by lukas_000 on 11.07.2015.
 */
@Entity
public class Possibility {

    @Id
    private Long key;

    private String description;

    public Possibility() { }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
