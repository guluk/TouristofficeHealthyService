package com.hevs.projectcloud.touristofficebackend;

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

    Long categoryId;
    Text title;
    Category category;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            List<Category> categories = ofy().load().type(Category.class).list();  // Result is async
            req.setAttribute("categories", categories);

            // Check if a specific page has been requested and redirect
            if (this.getInitParameter("page") != null) {
                switch (this.getInitParameter("page")) {
                    case "add":
                        this.getServletContext().getRequestDispatcher("/category/add.jsp").forward(req, resp);
                        break;
                    case "modify":
                        categoryId = Long.parseLong(req.getParameter("id"));
                        Category categorymodify = ofy().load().type(Category.class).id(categoryId).now();
                        req.setAttribute("categorymodify", categorymodify);

                        this.getServletContext().getRequestDispatcher("/category/modify.jsp").forward(req, resp);
                        break;
                    case "delete":
                        // Load entity to delete
                        categoryId = Long.parseLong(req.getParameter("id"));
                        Category category = ofy().load().type(Category.class).id(categoryId).now();

                        // Delete entity if exists
                        if (category != null) {
                            ofy().delete().entity(category).now();
                        }
                        this.getServletContext().getRequestDispatcher("/category/list.jsp").forward(req, resp);
                        break;
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
            switch (this.getInitParameter("page")) {
                case "add":
                    category = new Category();

                    // Prepare descriptions
                    title = new Text();
                    title.setText(
                        req.getParameter("titleEN"),
                        req.getParameter("titleFR"),
                        req.getParameter("titleDE")
                    );
                    // Save description
                    ofy().save().entity(title).now();

                    // Create data for object category
                    category.setTitle(title);

                    // Save entity
                    ofy().save().entity(category).now();
                    break;
                case "modify":

                    categoryId = Long.parseLong(req.getParameter("id"));
                    category = ofy().load().type(Category.class).id(categoryId).now();

                    title = new Text();
                    title.setText(
                            req.getParameter("titleEN"),
                            req.getParameter("titleFR"),
                            req.getParameter("titleDE")
                    );
                    // Save description
                    ofy().save().entity(title).now();

                    // Create data for object category
                    category.setTitle(title);

                    // Save entity
                    ofy().save().entity(category).now();

                    break;
            }
            resp.sendRedirect("/categories/list/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}