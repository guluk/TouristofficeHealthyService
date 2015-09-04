package com.hevs.projectcloud.touristofficebackend;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Query;
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
public class QuestionsServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Query query;

        try {
            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

             // Demande toutes les categories tries
            query = new Query("Questionnaires");
            List<Entity> questionnaires = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());

            query = new Query("Categories");
            List<Entity> categories = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());

            req.setAttribute("questionnaires", questionnaires);
            req.setAttribute("categories", categories);


            if (this.getInitParameter("page") != null) {
                switch (this.getInitParameter("page")) {
                    case "add":
                        this.getServletContext().getRequestDispatcher("/questionnaire/add.jsp").forward(req, resp);
                        break;
                    default:
                        this.getServletContext().getRequestDispatcher("/questionnaire/list.jsp").forward(req, resp);
                }
            } else {
                this.getServletContext().getRequestDispatcher("/questionnaire/list.jsp").forward(req, resp);
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


            Text description = new Text();
            description.setText(
                    req.getParameter("titleEN"),
                    req.getParameter("titleDE"),
                    req.getParameter("titleFR")
            );


            // Store related strings
            Entity titleEntity = new Entity("Text");
            titleEntity.setProperty("textEN", description.getTextEN());
            titleEntity.setProperty("textFR", description.getTextFR());
            titleEntity.setProperty("textDE", description.getTextDE());

            datastore.put(titleEntity);

            //ofy().save().entity(description).now();


            // get the categorie to add to the DB
            String catid = req.getParameter("cat");

            Category cat = ofy().load().type(Category.class).id(catid).now();

            Entity question = new Entity("Questions");
            question.setProperty("category", cat);
            question.setProperty("description", description);

            datastore.put(question);
            //ofy().save().entity(question).now();


            resp.sendRedirect("/questionnaires");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}