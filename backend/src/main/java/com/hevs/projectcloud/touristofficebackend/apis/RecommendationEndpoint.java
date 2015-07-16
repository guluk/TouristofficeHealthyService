package com.hevs.projectcloud.touristofficebackend.apis;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.hevs.projectcloud.touristofficebackend.Constants;
import com.hevs.projectcloud.touristofficebackend.models.Recommendation;

import java.util.List;
import java.util.logging.Logger;

import static com.hevs.projectcloud.touristofficebackend.OfyService.ofy;

/**
 * Created by lukas_000 on 12.07.2015.
 * for Cloud-Project 645-2 HES-SO Valais
 */
@Api(name = "questionnaires", version = "v1",
        namespace = @ApiNamespace(ownerDomain = Constants.API_OWNER,
                ownerName = Constants.API_OWNER,
                packagePath = Constants.API_PACKAGE_PATH))
public class RecommendationEndpoint {

    /**
     * Log output.
     */
    private static final Logger LOG = Logger
            .getLogger(QuestionnaireEndpoint.class.getName());

    /**
     * Lists all the entities inserted in datastore.
     * @return List of all Recommendation entities persisted.
     */
    @ApiMethod(httpMethod = "GET")
    public final List<Recommendation> listRecommendations() {
        return ofy().load().type(Recommendation.class).list();
    }

    /**
     * Gets the entity having primary key id.
     * @param id the primary key of the java bean Offer entity.
     * @return The entity with primary key id.
     */
    @ApiMethod(httpMethod = "GET")
    public final Recommendation getRecommendation(@Named("id") final Long id) {
        return findRecommendation(id);
    }

    /**
     * Inserts the entity into App Engine datastore. It uses HTTP POST method.
     * @param recommendation the entity to be inserted.
     * @return The inserted entity.
     */
    @ApiMethod(httpMethod = "POST")
    public final Recommendation insertRecommendation(final Recommendation recommendation) {
        ofy().save().entity(recommendation).now();
        return recommendation;
    }

    /**
     * Updates an entity. It uses HTTP PUT method.
     * @param recommendation the entity to be updated.
     * @return The updated entity.
     */
    @ApiMethod(httpMethod = "PUT")
    public final Recommendation updateRecommendation(final Recommendation recommendation) {
        ofy().save().entity(recommendation).now();
        return recommendation;
    }

    /**
     * Removes the entity with primary key id. It uses HTTP DELETE method.
     * @param id the primary key of the entity to be deleted.
     */
    @ApiMethod(httpMethod = "DELETE")
    public final void removeRecommendation(@Named("id") final Long id) {
        Recommendation recommendation = findRecommendation(id);
        if (recommendation == null) {
            LOG.info(
                    "Recommendation " + id + " not found, skipping deletion.");
            return;
        }
        ofy().delete().entity(recommendation).now();
    }

    /**
     * Searches an entity by ID.
     * @param id the recommendation ID to search
     * @return the Recommendation associated to id
     */
    private Recommendation findRecommendation(final Long id) {
        return ofy().load().type(Recommendation.class).id(id).now();
    }
}
