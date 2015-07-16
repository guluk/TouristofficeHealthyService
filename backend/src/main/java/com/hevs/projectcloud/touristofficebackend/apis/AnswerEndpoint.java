package com.hevs.projectcloud.touristofficebackend.apis;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.hevs.projectcloud.touristofficebackend.Constants;
import com.hevs.projectcloud.touristofficebackend.models.Answer;

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
public class AnswerEndpoint {

    /**
     * Log output.
     */
    private static final Logger LOG = Logger
            .getLogger(AnswerEndpoint.class.getName());

    /**
     * Lists all the entities inserted in datastore.
     * @return List of all Answer entities persisted.
     */
    @ApiMethod(httpMethod = "GET")
    public final List<Answer> listAnswers() {
        return ofy().load().type(Answer.class).list();
    }

    /**
     * Gets the entity having primary key id.
     * @param id the primary key of the java bean Answer entity.
     * @return The entity with primary key id.
     */
    @ApiMethod(httpMethod = "GET")
    public final Answer getAnswer(@Named("id") final Long id) {
        return findAnswer(id);
    }

    /**
     * Inserts the entity into App Engine datastore. It uses HTTP POST method.
     * @param answer the entity to be inserted.
     * @return The inserted entity.
     */
    @ApiMethod(httpMethod = "POST")
    public final Answer insertAnswer(final Answer answer) {
        ofy().save().entity(answer).now();
        return answer;
    }

    /**
     * Updates an entity. It uses HTTP PUT method.
     * @param answer the entity to be updated.
     * @return The updated entity.
     */
    @ApiMethod(httpMethod = "PUT")
    public final Answer updateAnswer(final Answer answer) {
        ofy().save().entity(answer).now();
        return answer;
    }

    /**
     * Removes the entity with primary key id. It uses HTTP DELETE method.
     * @param id the primary key of the entity to be deleted.
     */
    @ApiMethod(httpMethod = "DELETE")
    public final void removeAnswer(@Named("id") final Long id) {
        Answer answer = findAnswer(id);
        if (answer == null) {
            LOG.info(
                    "Answer " + id + " not found, skipping deletion.");
            return;
        }
        ofy().delete().entity(answer).now();
    }

    /**
     * Searches an entity by ID.
     * @param id the answer ID to search
     * @return the Answer associated to id
     */
    private Answer findAnswer(final Long id) {
        return ofy().load().type(Answer.class).id(id).now();
    }
}