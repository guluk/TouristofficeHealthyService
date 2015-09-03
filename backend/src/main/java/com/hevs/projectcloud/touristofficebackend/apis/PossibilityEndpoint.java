package com.hevs.projectcloud.touristofficebackend.apis;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiClass;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.hevs.projectcloud.touristofficebackend.Constants;
import com.hevs.projectcloud.touristofficebackend.models.Possibility;

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
@ApiClass(resource = "possibilities",
        clientIds = {
                Constants.ANDROID_CLIENT_ID,
                Constants.WEB_CLIENT_ID},
        audiences = {Constants.AUDIENCE_ID}
)
public class PossibilityEndpoint {

    /**
     * Log output.
     */
    private static final Logger LOG = Logger
            .getLogger(PossibilityEndpoint.class.getName());

    /**
     * Lists all the entities inserted in datastore.
     * @return List of all Possibility entities persisted.
     */
    @ApiMethod(httpMethod = "GET")
    public final List<Possibility> listPossibilities() {
        return ofy().load().type(Possibility.class).list();
    }

    /**
     * Gets the entity having primary key id.
     * @param id the primary key of the java bean Possibility entity.
     * @return The entity with primary key id.
     */
    @ApiMethod(httpMethod = "GET")
    public final Possibility getPossibility(@Named("id") final Long id) {
        return findPossibility(id);
    }

    /**
     * Inserts the entity into App Engine datastore. It uses HTTP POST method.
     * @param possibility the entity to be inserted.
     * @return The inserted entity.
     */
    @ApiMethod(httpMethod = "POST")
    public final Possibility insertPossibility(final Possibility possibility) {
        ofy().save().entity(possibility).now();
        return possibility;
    }

    /**
     * Updates an entity. It uses HTTP PUT method.
     * @param possibility the entity to be updated.
     * @return The updated entity.
     */
    @ApiMethod(httpMethod = "PUT")
    public final Possibility updatePossibility(final Possibility possibility) {
        ofy().save().entity(possibility).now();
        return possibility;
    }

    /**
     * Removes the entity with primary key id. It uses HTTP DELETE method.
     * @param id the primary key of the entity to be deleted.
     */
    @ApiMethod(httpMethod = "DELETE")
    public final void removePossibility(@Named("id") final Long id) {
        Possibility possibility = findPossibility(id);
        if (possibility == null) {
            LOG.info(
                    "Possibility " + id + " not found, skipping deletion.");
            return;
        }
        ofy().delete().entity(possibility).now();
    }

    /**
     * Searches an entity by ID.
     * @param id the possibility ID to search
     * @return the Possibility associated to id
     */
    private Possibility findPossibility(final Long id) {
        return ofy().load().type(Possibility.class).id(id).now();
    }
}