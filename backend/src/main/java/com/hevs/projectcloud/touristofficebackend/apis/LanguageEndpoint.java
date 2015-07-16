package com.hevs.projectcloud.touristofficebackend.apis;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.hevs.projectcloud.touristofficebackend.Constants;
import com.hevs.projectcloud.touristofficebackend.models.Language;

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
public class LanguageEndpoint {

    /**
     * Log output.
     */
    private static final Logger LOG = Logger
            .getLogger(LanguageEndpoint.class.getName());

    /**
     * Lists all the entities inserted in datastore.
     * @return List of all Language entities persisted.
     */
    @ApiMethod(httpMethod = "GET")
    public final List<Language> listLanguages() {
        return ofy().load().type(Language.class).list();
    }

    /**
     * Gets the entity having primary key id.
     * @param id the primary key of the java bean Language entity.
     * @return The entity with primary key id.
     */
    @ApiMethod(httpMethod = "GET")
    public final Language getLanguage(@Named("id") final Long id) {
        return findLanguage(id);
    }

    /**
     * Inserts the entity into App Engine datastore. It uses HTTP POST method.
     * @param language the entity to be inserted.
     * @return The inserted entity.
     */
    @ApiMethod(httpMethod = "POST")
    public final Language insertLanguage(final Language language) {
        ofy().save().entity(language).now();
        return language;
    }

    /**
     * Updates an entity. It uses HTTP PUT method.
     * @param language the entity to be updated.
     * @return The updated entity.
     */
    @ApiMethod(httpMethod = "PUT")
    public final Language updateLanguage(final Language language) {
        ofy().save().entity(language).now();
        return language;
    }

    /**
     * Removes the entity with primary key id. It uses HTTP DELETE method.
     * @param id the primary key of the entity to be deleted.
     */
    @ApiMethod(httpMethod = "DELETE")
    public final void removeLanguage(@Named("id") final Long id) {
        Language language = findLanguage(id);
        if (language == null) {
            LOG.info(
                    "Language " + id + " not found, skipping deletion.");
            return;
        }
        ofy().delete().entity(language).now();
    }

    /**
     * Searches an entity by ID.
     * @param id the language ID to search
     * @return the Language associated to id
     */
    private Language findLanguage(final Long id) {
        return ofy().load().type(Language.class).id(id).now();
    }
}