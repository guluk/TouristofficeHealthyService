package com.hevs.projectcloud.touristofficebackend.models;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * Created by lukas_000 on 11.07.2015.
 * for Cloud-Project 645-2 HES-SO Valais
 */
@Entity
public class Reply {

    @Id
    private Long id;

    private boolean value;

    public Reply() {}

    public Long getReplyId() {
        return this.id;
    }

    public boolean getValue() {
        return this.value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
}
