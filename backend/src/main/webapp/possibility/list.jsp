<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.appengine.api.datastore.*" %>
<%@ page import="java.util.List" %>

<%@include file="/header.jsp" %>

    <h1>
        Possibilities
        <a class="btn btn-primary btn-sm" href="/possibilities/add/">
            <span class="glyphicon glyphicon-plus"></span>
            Add Possibilitiy
        </a>
    </h1>

    <%
    List<Entity> possibilities = (List<Entity>) request.getAttribute("possibilities");
    for (Entity possibility : possibilities) {
    %>
        <p>
        Title: <strong><%= possibility.getProperty("description") %></strong>
        </p>
    <%
    }
    %>

<%@include file="/footer.html" %>