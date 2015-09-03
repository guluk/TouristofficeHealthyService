package com.hevs.projectcloud.touristofficebackend.apis;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiClass;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.hevs.projectcloud.touristofficebackend.Constants;
import com.hevs.projectcloud.touristofficebackend.models.Questionnaire;

import java.util.List;
import java.util.logging.Logger;

import static com.hevs.projectcloud.touristofficebackend.OfyService.ofy;

/**
 * Created by lukas_000 on 11.07.2015.
 * for Cloud-Project 645-2 HES-SO Valais
 */
@Api(name = "tohsaService", version = "v1",
        namespace = @ApiNamespace(ownerDomain = Constants.API_OWNER,
                ownerName = Constants.API_OWNER,
                packagePath = Constants.API_PACKAGE_PATH))
@ApiClass(resource = "questionnaires",
        clientIds = {
                Constants.ANDROID_CLIENT_ID,
                Constants.WEB_CLIENT_ID},
        audiences = {Constants.AUDIENCE_ID}
)
public class QuestionnaireEndpoint {

    /**
     * Log output.
     */
    private static final Logger LOG = Logger
            .getLogger(QuestionnaireEndpoint.class.getName());

    /**
     * Lists all the entities inserted in datastore.
     * @return List of all Questionnaire entities persisted.
     */
    @SuppressWarnings({"cast", "unchecked"})
    @ApiMethod(httpMethod = "GET")
    public final List<Questionnaire> listQuestionnaires() {
        return ofy().load().type(Questionnaire.class).list();
    }

    /**
     * Gets the entity having primary key id.
     * @param id the primary key of the java bean Questionnaire entity.
     * @return The entity with primary key id.
     */
    @ApiMethod(httpMethod = "GET")
    public final Questionnaire getQuestionnaire(@Named("id") final Long id) {
        return findQuestionnaire(id);
    }

    /**
     * Inserts the entity into App Engine datastore. It uses HTTP POST method.
     * @param questionnaire the entity to be inserted.
     * @return The inserted entity.
     */
    @ApiMethod(httpMethod = "POST")
    public final Questionnaire insertQuestionnaire(final Questionnaire questionnaire) {
        ofy().save().entity(questionnaire).now();
        return questionnaire;
    }

    /**
     * Updates an entity. It uses HTTP PUT method.
     * @param questionnaire the entity to be updated.
     * @return The updated entity.
     */
    @ApiMethod(httpMethod = "PUT")
    public final Questionnaire updateQuestionnaire(final Questionnaire questionnaire) {
        ofy().save().entity(questionnaire).now();
        return questionnaire;
    }

    /**
     * Removes the entity with primary key id. It uses HTTP DELETE method.
     * @param id the primary key of the entity to be deleted.
     */
    @ApiMethod(httpMethod = "DELETE")
    public final void removeQuestionnaire(@Named("id") final Long id) {
        Questionnaire questionnaire = findQuestionnaire(id);
        if (questionnaire == null) {
            LOG.info(
                    "Questionnaire " + id + " not found, skipping deletion.");
            return;
        }
        ofy().delete().entity(questionnaire).now();
    }

    /**
     * Searches an entity by ID.
     * @param id the questionnaire ID to search
     * @return the Questionnaire associated to id
     */
    private Questionnaire findQuestionnaire(final Long id) {
        return ofy().load().type(Questionnaire.class).id(id).now();
    }
}
