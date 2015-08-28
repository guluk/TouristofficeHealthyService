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
        <h1>Categories</h1>
        <%
        List<Entity> categories = (List<Entity>) request.getAttribute("categories");
        if (categories != null) {
            for (Entity category : categories) {
            %>
                <p>
                Title: <strong><%= category.getProperty("title") %></strong>
                </p>
            <%
            }
        } else {
        %>
            <p>There is no category</p>
        <%
        }
        %>
    </body>
</html>