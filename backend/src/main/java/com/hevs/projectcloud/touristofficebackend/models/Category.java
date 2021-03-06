package com.hevs.projectcloud.touristofficebackend.models;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * Created by lukas_000 on 11.07.2015.
 * for Cloud-Project 645-2 HES-SO Valais
 */
@Entity
public class Category {

    @Id
    private Long id;

    private Text title;

    public Category() {}

    public Long getCategoryId() {
        return this.id;
    }

    public Text getTitle() {
        return title;
    }

    public void setTitle(Text title) {
        this.title = title;
    }
}
