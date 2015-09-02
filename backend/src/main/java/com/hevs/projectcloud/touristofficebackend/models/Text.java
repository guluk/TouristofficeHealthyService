package com.hevs.projectcloud.touristofficebackend.models;

import com.googlecode.objectify.annotation.Id;

/**
 * Created by lukas_000 on 24.07.2015.
 * for Cloud-Project 645-2 HES-SO Valais
 */
public class Text {

    @Id
    private Long id;

    private String textEN;

    private String textFR;

    private String textDE;

    public static final String LANGUAGE_CODE_EN = "en";

    public static final String LANGUAGE_CODE_FR = "fr";

    public static final String LANGUAGE_CODE_DE = "de";

    public Text() {
        this.textEN = null;
        this.textFR = null;
        this.textDE = null;
    }

    /**
     * //LG/ Returns the text in the asked language
     * @param language the language code
     * @return the text in the language you asked for
     */
    public String getText(String language) {

        if(language == LANGUAGE_CODE_EN)
            return getTextEN();

        else if(language == LANGUAGE_CODE_FR)
            return getTextFR();

        else if(language == LANGUAGE_CODE_DE)
            return getTextDE();
        //LG/ returns the text in english if language code not known
        else
            return getTextEN();
    }

    /**
     *
     * @param textEN the text in english (can be null)
     * @param textFR the text in french (can be null)
     * @param textDE the text in german (can be null)
     */
    public void setText(String textEN, String textFR, String textDE) {
        setTextEN(textEN);
        setTextFR(textFR);
        setTextDE(textDE);
    }

    public String getTextEN() {
        return textEN;
    }

    public void setTextEN(String textEN) {
        this.textEN = textEN;
    }

    public String getTextFR() {
        return textFR;
    }

    public void setTextFR(String textFR) {
        this.textFR = textFR;
    }

    public String getTextDE() {
        return textDE;
    }

    public void setTextDE(String textDE) {
        this.textDE = textDE;
    }
}
