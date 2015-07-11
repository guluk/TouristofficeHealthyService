package com.hevs.projectcloud.touristofficebackend.models;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * Created by lukas_000 on 11.07.2015.
 */
@Entity
public class Locale {

    @Id
    private Long key;

    private String text;

    private Language language;

    public Locale() {}

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Language getLanguage() {
        return this.language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
