package com.hevs.projectcloud.touristofficebackend;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Query;
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

            // Query all possibilities
            query = new Query("Possibilities");
            List<Entity> possibilities = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
            req.setAttribute("possibilities", possibilities);

            // Check if a specific page has been requested and redirect
            if (this.getInitParameter("page") != null) {
                switch (this.getInitParameter("page")) {
                    case "add":
                        this.getServletContext().getRequestDispatcher("/possibility/add.jsp").forward(req, resp);
                        break;
                    default:
                        this.getServletContext().getRequestDispatcher("/possibility/list.jsp").forward(req, resp);
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
            Possibility possibility = new Possibility();
            ofy().save().entity(possibility).now();

            resp.sendRedirect("/possibilities/list/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}