<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.appengine.api.datastore.*" %>
<%@ page import="java.util.List" %>

<%@include file="/header.jsp" %>

        <form action="/questionnaires/post" method="post">
            <input text="Create questionnaires" type="submit"/>
        </form>

        <h1>Questionnaires
            <a class="btn btn-primary btn-sm" href="/questionnaire/new">
                <span class="glyphicon glyphicon-plus"></span>
                Add Questionnaire
            </a>
        </h1>

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

<%@include file="/footer.html" %>