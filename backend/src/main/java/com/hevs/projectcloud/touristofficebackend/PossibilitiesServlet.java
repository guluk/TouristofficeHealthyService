package com.hevs.projectcloud.touristofficebackend;

import com.hevs.projectcloud.touristofficebackend.models.Possibility;
import com.hevs.projectcloud.touristofficebackend.models.Question;
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
public class PossibilitiesServlet extends HttpServlet
{
    Long possibilityId;
    Possibility possibility;
    Text description;
    Question quest;
    Long questid;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        try {
            List<Possibility> possibilities = ofy().load().type(Possibility.class).list();  // Result is async
            req.setAttribute("possibilities", possibilities);

            //ask for a list of all questions
            List<Question> questions = ofy().load().type(Question.class).list();  // Result is async
            req.setAttribute("questions", questions);

            // Check if a specific page has been requested and redirect
            if (this.getInitParameter("page") != null) {
                switch (this.getInitParameter("page")) {
                    case "add":
                        this.getServletContext().getRequestDispatcher("/possibility/add.jsp").forward(req, resp);
                        break;
                    case "modify":
                        possibilityId = Long.parseLong(req.getParameter("id"));
                        Possibility possibilitymodify = ofy().load().type(Possibility.class).id(possibilityId).now();
                        req.setAttribute("possibilitymodify", possibilitymodify);

                        this.getServletContext().getRequestDispatcher("/possibility/modify.jsp").forward(req, resp);

                        break;
                    case "delete":
                        // Load entity to delete
                        possibilityId = Long.parseLong(req.getParameter("id"));
                        possibility = ofy().load().type(Possibility.class).id(possibilityId).now();

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
                    possibility = new Possibility();

                    // Prepare descriptions
                    description = new Text();
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


                    //get the object question
                    // add the possibility to a list
                    // save the question with the list
                    questid = Long.parseLong(req.getParameter("question"));
                    quest = ofy().load().type(Question.class).id(questid).now();

                    quest.addPossibility(possibility);

                    ofy().save().entity(quest).now();

                    break;
                case "modify":
                    possibilityId = Long.parseLong(req.getParameter("id"));
                    possibility = ofy().load().type(Possibility.class).id(possibilityId).now();

                    // Prepare descriptions
                    description = new Text();
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


                    //get the object question
                    // add the possibility to a list
                    // save the question with the list
                    questid = Long.parseLong(req.getParameter("question"));
                    quest = ofy().load().type(Question.class).id(questid).now();

                    quest.addPossibility(possibility);

                    ofy().save().entity(quest).now();

                    break;
            }
            resp.sendRedirect("/possibilities/list/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}