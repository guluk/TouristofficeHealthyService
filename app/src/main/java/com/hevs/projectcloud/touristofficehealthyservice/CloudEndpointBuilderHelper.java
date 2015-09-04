package com.hevs.projectcloud.touristofficehealthyservice;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;

import com.hevs.projectcloud.touristofficebackend.tohsaService.TohsaService;

import java.io.IOException;

/**
 * Created by lukas_000 on 03.09.2015.
 * for Cloud-Project 645-2 HES-SO Valais
 *
 * Allows configuring Cloud Endpoint builders to support authenticated calls, as
 * well as calls to Cloud Endpoints exposed from an App Engine backend
 * that run locally during development.
 */
public class CloudEndpointBuilderHelper {

    /**
     * Default constructor, never called.
     */
    private CloudEndpointBuilderHelper() {
    }

    /**
     *
     *
     * @return TohsaService endpoints to the GAE backend.
     */
    static TohsaService getEndpoints() {

        // Create API handler
        TohsaService.Builder builder = new TohsaService.Builder(
                AndroidHttp.newCompatibleTransport(),
                new AndroidJsonFactory(), getRequestInitializer())
                .setRootUrl(Constants.ROOT_URL)
                .setGoogleClientRequestInitializer(
                        new GoogleClientRequestInitializer() {
                            @Override
                            public void initialize(
                                    final AbstractGoogleClientRequest<?>
                                            abstractGoogleClientRequest)
                                    throws IOException {
                                abstractGoogleClientRequest
                                        .setDisableGZipContent(true);
                            }
                        }
                );

        return builder.build();
    }

    /**
     * Returns appropriate HttpRequestInitializer depending whether the
     * application is configured to require users to be signed in or not.
     * @return an appropriate HttpRequestInitializer.
     */
    static HttpRequestInitializer getRequestInitializer() {
        return new HttpRequestInitializer() {
            @Override
            public void initialize(final HttpRequest arg0) {
            }
        };
    }
}