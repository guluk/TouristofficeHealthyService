package com.hevs.projectcloud.touristofficebackend.apis;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.hevs.projectcloud.touristofficebackend.Constants;
import com.hevs.projectcloud.touristofficebackend.models.Feedback;

import java.util.List;
import java.util.logging.Logger;

import static com.hevs.projectcloud.touristofficebackend.OfyService.ofy;

/**
 * Created by lukas_000 on 11.07.2015.
 * for Cloud-Project 645-2 HES-SO Valais
 */
@Api(name = "questionnaires", version = "v1",
        namespace = @ApiNamespace(ownerDomain = Constants.API_OWNER,
                ownerName = Constants.API_OWNER,
                packagePath = Constants.API_PACKAGE_PATH))
public class FeedbackEndpoint {

    /**
     * Log output.
     */
    private static final Logger LOG = Logger
            .getLogger(FeedbackEndpoint.class.getName());

    /**
     * Lists all the entities inserted in datastore.
     * @return List of all Feedback entities persisted.
     */
    @ApiMethod(httpMethod = "GET")
    public final List<Feedback> listFeedbacks() {
        return ofy().load().type(Feedback.class).list();
    }

    /**
     * Gets the entity having primary key id.
     * @param id the primary key of the java bean Feedback entity.
     * @return The entity with primary key id.
     */
    @ApiMethod(httpMethod = "GET")
    public final Feedback getFeedback(@Named("id") final Long id) {
        return findFeedback(id);
    }

    /**
     * Inserts the entity into App Engine datastore. It uses HTTP POST method.
     * @param feedback the entity to be inserted.
     * @return The inserted entity.
     */
    @ApiMethod(httpMethod = "POST")
    public final Feedback insertFeedback(final Feedback feedback) {
        ofy().save().entity(feedback).now();
        return feedback;
    }

    /**
     * Updates an entity. It uses HTTP PUT method.
     * @param feedback the entity to be updated.
     * @return The updated entity.
     */
    @ApiMethod(httpMethod = "PUT")
    public final Feedback updateFeedback(final Feedback feedback) {
        ofy().save().entity(feedback).now();
        return feedback;
    }

    /**
     * Removes the entity with primary key id. It uses HTTP DELETE method.
     * @param id the primary key of the entity to be deleted.
     */
    @ApiMethod(httpMethod = "DELETE")
    public final void removeFeedback(@Named("id") final Long id) {
        Feedback feedback = findFeedback(id);
        if (feedback == null) {
            LOG.info(
                    "Feedback " + id + " not found, skipping deletion.");
            return;
        }
        ofy().delete().entity(feedback).now();
    }

    /**
     * Searches an entity by ID.
     * @param id the feedback ID to search
     * @return the Feedback associated to id
     */
    private Feedback findFeedback(final Long id) {
        return ofy().load().type(Feedback.class).id(id).now();
    }
}