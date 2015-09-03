package com.hevs.projectcloud.touristofficebackend.apis;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiClass;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.hevs.projectcloud.touristofficebackend.Constants;
import com.hevs.projectcloud.touristofficebackend.models.Category;

import java.util.List;
import java.util.logging.Logger;

import static com.hevs.projectcloud.touristofficebackend.OfyService.ofy;

/**
 * Created by lukas_000 on 12.07.2015.
 * for Cloud-Project 645-2 HES-SO Valais
 */
@Api(name = "tohsaService", version = "v1",
        namespace = @ApiNamespace(ownerDomain = Constants.API_OWNER,
                ownerName = Constants.API_OWNER,
                packagePath = Constants.API_PACKAGE_PATH))
@ApiClass(resource = "categories",
        clientIds = {
                Constants.ANDROID_CLIENT_ID,
                Constants.WEB_CLIENT_ID},
        audiences = {Constants.AUDIENCE_ID}
)
public class CategoryEndpoint {

    /**
     * Log output.
     */
    private static final Logger LOG = Logger
            .getLogger(CategoryEndpoint.class.getName());


    /**
     * Lists all categories.
     */
    @ApiMethod(httpMethod = "GET")
    public final List<Category> listCategories() {

        List<Category> categories = ofy().load().type(Category.class).list();

        return categories;
    }

    /**
     * Gets the entity having primary key id.
     * @param id the primary key of the java bean.
     * @return The entity with primary key id.
     */
    @ApiMethod(httpMethod = "GET")
    public final Category getCategory(@Named("id") final Long id) {
        return findCategory(id);
    }

    /**
     * Inserts the entity into App Engine datastore. It uses HTTP POST method.
     * @param category the entity to be inserted.
     * @return The inserted entity.
     */
    @ApiMethod(httpMethod = "POST")
    public final Category insertCategory(final Category category) {
        ofy().save().entity(category).now();
        return category;
    }

    /**
     * Updates an entity. It uses HTTP PUT method.
     * @param category the entity to be updated.
     * @return The updated entity.
     */
    @ApiMethod(httpMethod = "PUT")
    public final Category updateCategory(final Category category) {
        ofy().save().entity(category).now();
        return category;
    }


    /**
     * Removes the entity with primary key id. It uses HTTP DELETE method.
     * @param id the primary key of the entity to be deleted.
     */
    @ApiMethod(httpMethod = "DELETE")
    public final void removeCategory(@Named("id") final Long id) {

        Category category = findCategory(id);

        if (category == null) {
            LOG.info(
                    "Category " + id + " not found, skipping deletion.");
            return;
        }
        ofy().delete().entity(category).now();
    }

    /**
     * Searches an entity by ID.
     * @param id the question ID to search
     * @return the Category associated to id
     */
    private Category findCategory(final Long id) {
        return ofy().load().type(Category.class).id(id).now();
    }
}
