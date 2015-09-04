package com.hevs.projectcloud.touristofficebackend;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Query;
import com.hevs.projectcloud.touristofficebackend.apis.CategoryEndpoint;
import com.hevs.projectcloud.touristofficebackend.models.Category;
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
public class CategoriesServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Query query;
        List<Entity> results;
        List<Entity> resultsObjs;

        try {
            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

             // Demande toutes les categories tries
            query = new Query("Categories");
            results = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());

            req.setAttribute("categories", results);

            if (this.getInitParameter("page") != null) {
                switch (this.getInitParameter("page")) {
                    case "add":
                        this.getServletContext().getRequestDispatcher("/category/add.jsp").forward(req, resp);
                        break;
                    default:
                        this.getServletContext().getRequestDispatcher("/category/list.jsp").forward(req, resp);
                }
            } else {
                this.getServletContext().getRequestDispatcher("/category/list.jsp").forward(req, resp);
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

           DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();


            Text title = new Text();
            title.setText(
                req.getParameter("titleEN"),
                    req.getParameter("titleFR"),
                req.getParameter("titleDE")

            );


            // Store related strings
            Entity titleEntity = new Entity("Text");
            titleEntity.setProperty("textEN", title.getTextEN());
            titleEntity.setProperty("textFR", title.getTextFR());
            titleEntity.setProperty("textDE", title.getTextDE());

            datastore.put(titleEntity);


            // Store a category
           Entity category = new Entity("Categories");
            category.setProperty("titleEN", title.getTextEN());
            category.setProperty("titleFR", title.getTextFR());
            category.setProperty("titleDE", title.getTextDE());




            datastore.put(category);


            resp.sendRedirect("/categories/list/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}