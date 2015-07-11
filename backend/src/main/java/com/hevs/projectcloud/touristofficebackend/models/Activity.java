package com.hevs.projectcloud.touristofficebackend.models;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * Created by lukas_000 on 11.07.2015.
 */
@Entity
public class Activity {

    @Id
    private Long key;

    private String name;

    public Activity() { }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
