package com.hevs.projectcloud.touristofficebackend.apis;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.hevs.projectcloud.touristofficebackend.Constants;
import com.hevs.projectcloud.touristofficebackend.models.Question;

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
public class QuestionEndpoint {

    /**
     * Log output.
     */
    private static final Logger LOG = Logger
            .getLogger(QuestionEndpoint.class.getName());


    /**
     * Lists all questions.
     */
    @ApiMethod(httpMethod = "GET")
    public final List<Question> listQuestions() {

        List<Question> questions = ofy().load().type(Question.class).list();

        return questions;
    }

    /**
     * Gets the entity having primary key id.
     * @param id the primary key of the java bean.
     * @return The entity with primary key id.
     */
    @ApiMethod(httpMethod = "GET")
    public final Question getQuestion(@Named("id") final Long id) {
        return findQuestion(id);
    }

    /**
     * Inserts the entity into App Engine datastore. It uses HTTP POST method.
     * @param question the entity to be inserted.
     * @return The inserted entity.
     */
    @ApiMethod(httpMethod = "POST")
    public final Question insertQuestion(final Question question) {
        ofy().save().entity(question).now();
        return question;
    }

    /**
     * Updates an entity. It uses HTTP PUT method.
     * @param question the entity to be updated.
     * @return The updated entity.
     */
    @ApiMethod(httpMethod = "PUT")
    public final Question updateQuestion(final Question question) {
        ofy().save().entity(question).now();
        return question;
    }


    /**
     * Removes the entity with primary key id. It uses HTTP DELETE method.
     * @param id the primary key of the entity to be deleted.
     */
    @ApiMethod(httpMethod = "DELETE")
    public final void removeQuestion(@Named("id") final Long id) {

        Question question = findQuestion(id);

        if (question == null) {
            LOG.info(
                    "Question " + id + " not found, skipping deletion.");
            return;
        }
        ofy().delete().entity(question).now();
    }

    /**
     * Searches an entity by ID.
     * @param id the question ID to search
     * @return the Question associated to id
     */
    private Question findQuestion(final Long id) {
        return ofy().load().type(Question.class).id(id).now();
    }
}