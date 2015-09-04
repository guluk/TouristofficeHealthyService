package com.hevs.projectcloud.touristofficebackend;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Query;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.LoadResult;
import com.googlecode.objectify.cmd.LoadType;
import com.hevs.projectcloud.touristofficebackend.models.Category;
import com.hevs.projectcloud.touristofficebackend.models.Possibility;
import com.hevs.projectcloud.touristofficebackend.models.Text;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.hevs.projectcloud.touristofficebackend.OfyService.ofy;

/**
 * Created by samuel on 9/2/15.
 */
public class PossibilitiesServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Query query;

        try {
            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

            List<Possibility> possibilities = ofy().load().type(Possibility.class).list();  // Result is async
            req.setAttribute("possibilities", possibilities);

            // Check if a specific page has been requested and redirect
            if (this.getInitParameter("page") != null) {
                switch (this.getInitParameter("page")) {
                    case "add":
                        this.getServletContext().getRequestDispatcher("/possibility/add.jsp").forward(req, resp);
                        break;
                    case "delete":
                        // Load entity to delete
                        Long possibilityId = Long.parseLong(req.getParameter("id"));
                        Possibility possibility = ofy().load().type(Possibility.class).id(possibilityId).now();

                        // Delete entity if exists
                        if (possibility != null) {
                            ofy().delete().entity(possibility).now();
                        }
                        this.getServletContext().getRequestDispatcher("/possibility/list.jsp").forward(req, resp);
                        break;
                }
            } else {
                this.getServletContext().getRequestDispatcher("/possibility/list.jsp").forward(req, resp);
            }

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Process the http POST of the form
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            switch (this.getInitParameter("page")) {
                case "add":
                    Possibility possibility = new Possibility();

                    // Prepare descriptions
                    Text description = new Text();
                    description.setText(
                            req.getParameter("descriptionEN"),
                            req.getParameter("descriptionDE"),
                            req.getParameter("descriptionFR")
                    );

                    // Save description
                    ofy().save().entity(description).now();

                    // Create data for object possibility
                    possibility.setDescription(description);
                    possibility.setPoints(Integer.parseInt(req.getParameter("points")));

                    // Save entity
                    ofy().save().entity(possibility).now();
                    break;
            }
            resp.sendRedirect("/possibilities/list/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}