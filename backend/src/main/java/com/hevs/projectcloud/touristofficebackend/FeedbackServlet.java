package com.hevs.projectcloud.touristofficebackend;

import com.hevs.projectcloud.touristofficebackend.models.Feedback;
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
public class FeedbackServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            List<Feedback> feedback = ofy().load().type(Feedback.class).list();  // Result is async
            req.setAttribute("feedback", feedback);

            // Check if a specific page has been requested and redirect
            if (this.getInitParameter("page") != null) {
                switch (this.getInitParameter("page")) {
                    case "list":
                        this.getServletContext().getRequestDispatcher("/feedback/list.jsp").forward(req, resp);
                        break;

                }
            } else {
                this.getServletContext().getRequestDispatcher("/feedback/list.jsp").forward(req, resp);
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
            resp.sendRedirect("/feedback/list/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}