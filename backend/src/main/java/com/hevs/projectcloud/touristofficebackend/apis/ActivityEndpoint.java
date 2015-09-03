package com.hevs.projectcloud.touristofficebackend.apis;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiClass;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.hevs.projectcloud.touristofficebackend.Constants;
import com.hevs.projectcloud.touristofficebackend.models.Activity;

import java.util.List;
import java.util.logging.Logger;

import static com.hevs.projectcloud.touristofficebackend.OfyService.ofy;

/**
 * Created by lukas_000 on 11.07.2015.
 * for Cloud-Project 645-2 HES-SO Valais
 */
@Api(name = "tohsaService", version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = Constants.API_OWNER,
                ownerName = Constants.API_OWNER,
                packagePath = Constants.API_PACKAGE_PATH)
)
@ApiClass (resource = "activities",
        clientIds = {
                Constants.ANDROID_CLIENT_ID,
                Constants.WEB_CLIENT_ID},
        audiences = {Constants.AUDIENCE_ID}
)
public class ActivityEndpoint {

    /**
     * Log output.
     */
    private static final Logger LOG = Logger
            .getLogger(ActivityEndpoint.class.getName());

    /**
     * Lists all the entities inserted in datastore.
     * @return List of all Activity entities persisted.
     */
    @ApiMethod(httpMethod = "GET")
    public final List<Activity> listActivities() {
        return ofy().load().type(Activity.class).list();
    }

    /**
     * Gets the entity having primary key id.
     * @param id the primary key of the java bean Activity entity.
     * @return The entity with primary key id.
     */
    @ApiMethod(httpMethod = "GET")
    public final Activity getActivity(@Named("id") final Long id) {
        return findActivity(id);
    }

    /**
     * Inserts the entity into App Engine datastore. It uses HTTP POST method.
     * @param activity the entity to be inserted.
     * @return The inserted entity.
     */
    @ApiMethod(httpMethod = "POST")
    public final Activity insertActivity(final Activity activity) {
        ofy().save().entity(activity).now();
        return activity;
    }

    /**
     * Updates an entity. It uses HTTP PUT method.
     * @param activity the entity to be updated.
     * @return The updated entity.
     */
    @ApiMethod(httpMethod = "PUT")
    public final Activity updateActivity(final Activity activity) {
        ofy().save().entity(activity).now();
        return activity;
    }

    /**
     * Removes the entity with primary key id. It uses HTTP DELETE method.
     * @param id the primary key of the entity to be deleted.
     */
    @ApiMethod(httpMethod = "DELETE")
    public final void removeActivity(@Named("id") final Long id) {
        Activity activity = findActivity(id);
        if (activity == null) {
            LOG.info(
                    "Activity " + id + " not found, skipping deletion.");
            return;
        }
        ofy().delete().entity(activity).now();
    }

    /**
     * Searches an entity by ID.
     * @param id the activity ID to search
     * @return the Activity associated to id
     */
    private Activity findActivity(final Long id) {
        return ofy().load().type(Activity.class).id(id).now();
    }
}
