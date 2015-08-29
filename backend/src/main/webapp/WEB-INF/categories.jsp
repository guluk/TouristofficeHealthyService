<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.appengine.api.datastore.*" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Tourist office</title>
        <meta charset="utf-8" />
    </head>
    <body>
        <h1>
            Categories
            <a class="btn btn-primary btn-sm" href="/add_category">
                <span class="glyphicon glyphicon-plus"></span>
                Add Category
            </a>
        </h1>

        <%
        List<Entity> categories = (List<Entity>) request.getAttribute("categories");
        for (Entity category : categories) {
        %>
            <p>
            Title: <strong><%= category.getProperty("title") %></strong>
            </p>
        <%
        }
        %>
    </body>
</html>