package com.hevs.projectcloud.touristofficebackend;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.hevs.projectcloud.touristofficebackend.models.Text;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by samuel on 9/2/15.
 */
public class CategoriesServlet extends HttpServlet {

    // Process the http POST of the form
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

            Text title = new Text();
            title.setText(
                req.getParameter("titleEN"),
                req.getParameter("titleDE"),
                req.getParameter("titleFR")
            );

            // Store a category
            Entity category = new Entity("Categories");
            category.setProperty("title", title.getTextEN());
            datastore.put(category);

            // Store related strings
            Entity titleEntity = new Entity("Textes");
            titleEntity.setProperty("textFR", title.getTextFR());
            titleEntity.setProperty("textDE", title.getTextDE());
            titleEntity.setProperty("textEN", title.getTextEN());
            datastore.put(titleEntity);

            resp.sendRedirect("/categories");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}