<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.appengine.api.datastore.*" %>
<%@ page import="java.util.List" %>

<%@include file="/header.jsp" %>

    <h1>
        Categories
        <a class="btn btn-primary btn-sm" href="/questionnaires/add/">
            <span class="glyphicon glyphicon-plus"></span>
            Add Question
        </a>
    </h1>

    <%
    List<Entity> questions = (List<Entity>) request.getAttribute("questionnaires");
    for (Entity questions : questions) {
    %>
        <p>
        TitleEN: <strong><%= questions.getProperty("descriptionEN") %></strong>

        </p>
    <%
    }
    %>

<%@include file="/footer.html" %>