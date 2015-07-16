package com.hevs.projectcloud.touristofficebackend.apis;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.hevs.projectcloud.touristofficebackend.Constants;
import com.hevs.projectcloud.touristofficebackend.models.Locale;

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
public class LocaleEndpoint {

    /**
     * Log output.
     */
    private static final Logger LOG = Logger
            .getLogger(LocaleEndpoint.class.getName());

    /**
     * Lists all the entities inserted in datastore.
     * @return List of all Locale entities persisted.
     */
    @ApiMethod(httpMethod = "GET")
    public final List<Locale> listLocales() {
        return ofy().load().type(Locale.class).list();
    }

    /**
     * Gets the entity having primary key id.
     * @param id the primary key of the java bean Locale entity.
     * @return The entity with primary key id.
     */
    @ApiMethod(httpMethod = "GET")
    public final Locale getLocale(@Named("id") final Long id) {
        return findLocale(id);
    }

    /**
     * Inserts the entity into App Engine datastore. It uses HTTP POST method.
     * @param locale the entity to be inserted.
     * @return The inserted entity.
     */
    @ApiMethod(httpMethod = "POST")
    public final Locale insertLocale(final Locale locale) {
        ofy().save().entity(locale).now();
        return locale;
    }

    /**
     * Updates an entity. It uses HTTP PUT method.
     * @param locale the entity to be updated.
     * @return The updated entity.
     */
    @ApiMethod(httpMethod = "PUT")
    public final Locale updateLocale(final Locale locale) {
        ofy().save().entity(locale).now();
        return locale;
    }

    /**
     * Removes the entity with primary key id. It uses HTTP DELETE method.
     * @param id the primary key of the entity to be deleted.
     */
    @ApiMethod(httpMethod = "DELETE")
    public final void removeLocale(@Named("id") final Long id) {
        Locale locale = findLocale(id);
        if (locale == null) {
            LOG.info(
                    "Locale " + id + " not found, skipping deletion.");
            return;
        }
        ofy().delete().entity(locale).now();
    }

    /**
     * Searches an entity by ID.
     * @param id the locale ID to search
     * @return the Locale associated to id
     */
    private Locale findLocale(final Long id) {
        return ofy().load().type(Locale.class).id(id).now();
    }
}