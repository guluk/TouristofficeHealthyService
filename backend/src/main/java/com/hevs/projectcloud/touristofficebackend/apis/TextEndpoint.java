package com.hevs.projectcloud.touristofficebackend.apis;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiClass;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.hevs.projectcloud.touristofficebackend.Constants;
import com.hevs.projectcloud.touristofficebackend.models.Text;

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
@ApiClass(resource = "texts",
        clientIds = {
                Constants.ANDROID_CLIENT_ID,
                Constants.WEB_CLIENT_ID},
        audiences = {Constants.AUDIENCE_ID}
)
public class TextEndpoint {

    /**
     * Log output.
     */
    private static final Logger LOG = Logger
            .getLogger(TextEndpoint.class.getName());

    /**
     * Lists all the entities inserted in datastore.
     * @return List of all Text entities persisted.
     */
    @ApiMethod(httpMethod = "GET")
    public final List<Text> listTextes() {
        return ofy().load().type(Text.class).list();
    }

    /**
     * Gets the entity having primary key id.
     * @param id the primary key of the java bean Text entity.
     * @return The entity with primary key id.
     */
    @ApiMethod(httpMethod = "GET")
    public final Text getText(@Named("id") final Long id) {
        return findText(id);
    }

    /**
     * Inserts the entity into App Engine datastore. It uses HTTP POST method.
     * @param text the entity to be inserted.
     * @return The inserted entity.
     */
    @ApiMethod(httpMethod = "POST")
    public final Text insertText(final Text text) {
        ofy().save().entity(text).now();
        return text;
    }

    /**
     * Updates an entity. It uses HTTP PUT method.
     * @param text the entity to be updated.
     * @return The updated entity.
     */
    @ApiMethod(httpMethod = "PUT")
    public final Text updateText(final Text text) {
        ofy().save().entity(text).now();
        return text;
    }

    /**
     * Removes the entity with primary key id. It uses HTTP DELETE method.
     * @param id the primary key of the entity to be deleted.
     */
    @ApiMethod(httpMethod = "DELETE")
    public final void removeText(@Named("id") final Long id) {
        Text text = findText(id);
        if (text == null) {
            LOG.info(
                    "Text " + id + " not found, skipping deletion.");
            return;
        }
        ofy().delete().entity(text).now();
    }

    /**
     * Searches an entity by ID.
     * @param id the text ID to search
     * @return the Text associated to id
     */
    private Text findText(final Long id) {
        return ofy().load().type(Text.class).id(id).now();
    }
}