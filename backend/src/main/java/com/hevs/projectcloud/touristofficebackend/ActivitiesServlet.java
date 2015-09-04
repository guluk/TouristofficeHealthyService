package com.hevs.projectcloud.touristofficebackend;

import com.hevs.projectcloud.touristofficebackend.models.Activity;
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
public class ActivitiesServlet extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        try {
            List<Activity> activities = ofy().load().type(Activity.class).list();  // Result is async
            req.setAttribute("activities", activities);

            // Check if a specific page has been requested and redirect
            if (this.getInitParameter("page") != null) {
                switch (this.getInitParameter("page")) {
                    case "add":
                        this.getServletContext().getRequestDispatcher("/activity/add.jsp").forward(req, resp);
                        break;
                    case "delete":
                        // Load entity to delete
                        Long activityId = Long.parseLong(req.getParameter("id"));
                        Activity activity = ofy().load().type(Activity.class).id(activityId).now();

                        // Delete entity if exists
                        if (activity != null) {
                            ofy().delete().entity(activity).now();
                        }
                        this.getServletContext().getRequestDispatcher("/activity/list.jsp").forward(req, resp);
                        break;
                }
            } else {
                this.getServletContext().getRequestDispatcher("/activity/list.jsp").forward(req, resp);
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
                    Activity activity = new Activity();

                    // Prepare descriptions
                    Text name = new Text();
                    name.setText(
                            req.getParameter("nameEN"),
                            req.getParameter("nameDE"),
                            req.getParameter("nameFR")
                    );

                    // Save description
                    ofy().save().entity(name).now();

                    // Create data for object activity
                    activity.setName(name);

                    // Save entity
                    ofy().save().entity(activity).now();
                    break;
            }
            resp.sendRedirect("/activities/list/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}