package com.hevs.projectcloud.touristofficebackend;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Query;
import com.hevs.projectcloud.touristofficebackend.models.Category;
import com.hevs.projectcloud.touristofficebackend.models.Text;
import com.hevs.projectcloud.touristofficebackend.models.Question;

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

    Long questionId;
    Text description;
    Question question;
    Category cat;
    String catid;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Query query;

        try {
            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

            //ask for a list of all questions
            List<Question> questions = ofy().load().type(Question.class).list();  // Result is async
            req.setAttribute("questions", questions);

            // Demande toutes les categories tries
            List<Category> categories = ofy().load().type(Category.class).list();  // Result is async
            req.setAttribute("categories", categories);


            if (this.getInitParameter("page") != null) {
                switch (this.getInitParameter("page")) {
                    case "add":
                        this.getServletContext().getRequestDispatcher("/question/add.jsp").forward(req, resp);
                        break;
                    case "modify":
                        questionId = Long.parseLong(req.getParameter("id"));
                        Question questionmodify = ofy().load().type(Question.class).id(questionId).now();
                        req.setAttribute("questionmodify", questionmodify);

                        this.getServletContext().getRequestDispatcher("/question/modify.jsp").forward(req, resp);
                        break;
                    case "delete":
                        // Load entity to delete
                        questionId = Long.parseLong(req.getParameter("id"));
                        question = ofy().load().type(Question.class).id(questionId).now();

                        // Delete entity if exists
                        if (question != null) {
                            ofy().delete().entity(question).now();
                        }
                        this.getServletContext().getRequestDispatcher("/question/list.jsp").forward(req, resp);
                        break;
                    default:
                        this.getServletContext().getRequestDispatcher("/question/list.jsp").forward(req, resp);
                }
            } else {
                this.getServletContext().getRequestDispatcher("/question/list.jsp").forward(req, resp);
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

                    description = new Text();
                    description.setText(
                            req.getParameter("titleEN"),
                            req.getParameter("titleDE"),
                            req.getParameter("titleFR")
                    );
                    ofy().save().entity(description).now();


                    //save the question with properties
                    question = new Question();

                    // get the categorie to add to the question
                    catid = req.getParameter("cat");
                    if (catid != null) {
                        cat = ofy().load().type(Category.class).id(Long.parseLong(catid)).now();
                        question.setCategory(cat);
                    }
                    question.setDescription(description);

                    ofy().save().entity(question).now();
                break;

                case "modify":
                    questionId = Long.parseLong(req.getParameter("id"));
                    question = ofy().load().type(Question.class).id(questionId).now();

                    description = new Text();
                    description.setText(
                            req.getParameter("titleEN"),
                            req.getParameter("titleDE"),
                            req.getParameter("titleFR")
                    );

                    ofy().save().entity(description).now();

                    // get the categorie to add to the question
                    catid = req.getParameter("cat");
                    cat = ofy().load().type(Category.class).id(Long.parseLong(catid)).now();


                    //save the question with properties
                    question.setCategory(cat);
                    question.setDescription(description);


                    ofy().save().entity(question).now();


                    break;


            }
            resp.sendRedirect("/questions/list/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}