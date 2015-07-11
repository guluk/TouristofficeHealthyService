package com.hevs.projectcloud.touristofficebackend.models;

import com.googlecode.objectify.annotation.Entity;

import java.util.List;

/**
 * Created by lukas_000 on 11.07.2015.
 */
@Entity
public class Question extends Feedback {

    private List<Category> categories;

    public Question() { }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Category> getCategories() {
        return this.categories;
    }

}
