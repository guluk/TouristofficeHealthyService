package com.hevs.projectcloud.touristofficebackend.apis;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiClass;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.hevs.projectcloud.touristofficebackend.Constants;
import com.hevs.projectcloud.touristofficebackend.models.Reply;

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
@ApiClass(resource = "replies",
        clientIds = {
                Constants.ANDROID_CLIENT_ID,
                Constants.WEB_CLIENT_ID},
        audiences = {Constants.AUDIENCE_ID}
)
public class ReplyEndpoint {

    /**
     * Log output.
     */
    private static final Logger LOG = Logger
            .getLogger(ReplyEndpoint.class.getName());

    /**
     * Lists all the entities inserted in datastore.
     * @return List of all Reply entities persisted.
     */
    @ApiMethod(httpMethod = "GET")
    public final List<Reply> listReplies() {
        return ofy().load().type(Reply.class).list();
    }

    /**
     * Gets the entity having primary key id.
     * @param id the primary key of the java bean Reply entity.
     * @return The entity with primary key id.
     */
    @ApiMethod(httpMethod = "GET")
    public final Reply getReply(@Named("id") final Long id) {
        return findReply(id);
    }

    /**
     * Inserts the entity into App Engine datastore. It uses HTTP POST method.
     * @param reply the entity to be inserted.
     * @return The inserted entity.
     */
    @ApiMethod(httpMethod = "POST")
    public final Reply insertReply(final Reply reply) {
        ofy().save().entity(reply).now();
        return reply;
    }

    /**
     * Updates an entity. It uses HTTP PUT method.
     * @param reply the entity to be updated.
     * @return The updated entity.
     */
    @ApiMethod(httpMethod = "PUT")
    public final Reply updateReply(final Reply reply) {
        ofy().save().entity(reply).now();
        return reply;
    }

    /**
     * Removes the entity with primary key id. It uses HTTP DELETE method.
     * @param id the primary key of the entity to be deleted.
     */
    @ApiMethod(httpMethod = "DELETE")
    public final void removeReply(@Named("id") final Long id) {
        Reply reply = findReply(id);
        if (reply == null) {
            LOG.info(
                    "Reply " + id + " not found, skipping deletion.");
            return;
        }
        ofy().delete().entity(reply).now();
    }

    /**
     * Searches an entity by ID.
     * @param id the reply ID to search
     * @return the Reply associated to id
     */
    private Reply findReply(final Long id) {
        return ofy().load().type(Reply.class).id(id).now();
    }
}