package com.hevs.projectcloud.touristofficebackend;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Query;
import com.hevs.projectcloud.touristofficebackend.models.Questionnaire;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.util.List;

/**
 * Created by lukas_000 on 04.07.2015.
 */
public class TouristOfficeServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        try {
            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

            // Demande tous les questionnaires triés
            Query q = new Query("Questionnaires");
            List<Entity> results = datastore.prepare(q).asList(FetchOptions.Builder.withDefaults());

            q = new Query("QuestionnaireObjs");
            List<Entity> resultsObjs = datastore.prepare(q).asList(FetchOptions.Builder.withDefaults());

            req.setAttribute("questionnaires", results);
            this.getServletContext().getRequestDispatcher("/WEB-INF/touristoffice.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) {

        try {
            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

            Entity questionnaire1 = new Entity("Questionnaires");
            questionnaire1.setProperty("credentials", "ga");

            Entity questionnaire2 = new Entity("Questionnaires");
            questionnaire2.setProperty("credentials", "sd");

            Entity questionnaire3 = new Entity("Questionnaires");
            questionnaire3.setProperty("credentials", "lg");

            Entity questionnaire4 = new Entity("Questionnaires");
            questionnaire4.setProperty("credentials", "dp");

            datastore.put(questionnaire1);
            datastore.put(questionnaire2);
            datastore.put(questionnaire3);
            datastore.put(questionnaire4);

            createOtherEntities();

            resp.sendRedirect("/");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void createOtherEntities() {

        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

        //LG/ Store a question
        Entity question1 = new Entity("Questions");
        question1.setProperty("description", "this is a question");
        /* TODO add relation to questionnaire */
        /* TODO add relation to category */
        datastore.put(question1);

        //LG/ Store a possiblity
        Entity possibility1 = new Entity("Possibilities");
        possibility1.setProperty("description", "this is a possibility");
        /* TODO add relation to question */
        datastore.put(possibility1);

        //LG/ Store an answer
        Entity answer1 = new Entity("Answers");
        answer1.setProperty("points", 10);
        /* TODO add relation to possibility */
        datastore.put(answer1);

        // Store a category
        Entity category1 = new Entity("Categories");
        category1.setProperty("title", "Title of my first category");
        datastore.put(category1);

        // Store a recommodation
        Entity recommodation1 = new Entity("Recommodations");
        recommodation1.setProperty("pivot", 0.5);
        /* TODO add relation to category */
        datastore.put(recommodation1);

        // Store an activity
        Entity activity1 = new Entity("Activities");
        activity1.setProperty("description", "this is an activity");
        /* TODO add relation to recommodation */
        datastore.put(activity1);

    }
}
