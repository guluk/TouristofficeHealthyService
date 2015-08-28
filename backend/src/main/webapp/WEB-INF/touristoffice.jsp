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
        <form action="/post" method="post">
            <input text="Create questionnaires" type="submit"/>
        </form>

        <p>Here are the available questionnaires:</p>

        <h1>Questionnaires</h1>
        <p><em>(stored in Google Datastore)</em></p>
        <%
            List<Entity> questionnaires = (List<Entity>) request.getAttribute("questionnaires");
            for (Entity questionnaire : questionnaires) {
        %>
        <p>
            Credentials: <strong><%= questionnaire.getProperty("credentials") %></strong>
        </p>
        <%
            }
        %>
    </body>
</html>