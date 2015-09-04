package com.hevs.projectcloud.touristofficebackend;

import com.hevs.projectcloud.touristofficebackend.models.Questionnaire;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.util.List;

import static com.hevs.projectcloud.touristofficebackend.OfyService.ofy;

/**
 * Created by lukas_000 on 04.07.2015.
 */
public class QuestionnairesServlet extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        try {
            List<Questionnaire> questionnaires = ofy().load().type(Questionnaire.class).list();  // Result is async
            req.setAttribute("questionnaires", questionnaires);

            // Check if a specific page has been requested and redirect
            if (this.getInitParameter("page") != null) {
                switch (this.getInitParameter("page")) {
                    case "add":
                        this.getServletContext().getRequestDispatcher("/questionnaire/add.jsp").forward(req, resp);
                        break;
                    case "delete":
                        // Load entity to delete
                        Long questionnaireId = Long.parseLong(req.getParameter("id"));
                        Questionnaire questionnaire = ofy().load().type(Questionnaire.class).id(questionnaireId).now();

                        // Delete entity if exists
                        if (questionnaire != null) {
                            ofy().delete().entity(questionnaire).now();
                        }
                        this.getServletContext().getRequestDispatcher("/questionnaire/list.jsp").forward(req, resp);
                        break;
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

    public void doPost(HttpServletRequest req, HttpServletResponse resp) {

        try {
            switch (this.getInitParameter("page")) {
                case "add":
                    Questionnaire questionnaire = new Questionnaire();

                    // Create data for object possibility
                    questionnaire.setCredentials(req.getParameter("credentials"));
                    questionnaire.setPhoneNumber(req.getParameter("phone"));

                    // Save entity
                    ofy().save().entity(questionnaire).now();
                    break;
            }
            resp.sendRedirect("/questionnaires/list/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
