package com.hevs.projectcloud.touristofficebackend;

/**
 * Created by lukas_000 on 13.07.2015.
 * for Cloud-Project 645-2 HES-SO Valais
 */
public final class Constants {


    /**
     * Google Cloud Messaging API key.
     */
    public static final String GCM_API_KEY = "AIzaSyDxbR9oJze3uEXQjkk54UJiWez38mSMGwg";

    /**
     * Android client ID from Google Cloud console.
     */
    public static final String ANDROID_CLIENT_ID = "touristofficehealthyservice";

    /**
     * Web client ID from Google Cloud console.
     */
    public static final String WEB_CLIENT_ID = "AIzaSyDGxbOxFs6z1zq7VCcUNqhPwRTr9oyZUBE";

    /**
     * Audience ID used to limit access to some client to the API.
     */
    public static final String AUDIENCE_ID = WEB_CLIENT_ID;

    /**
     * API package name.
     */
    public static final String API_OWNER =
            "touristofficebackend.projectcloud.hevs.com";

    /**
     * API package path.
     */
    public static final String API_PACKAGE_PATH = "";

    /**
     * Default constructor, never called.
     */
    private Constants() { }
}
