<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.appengine.api.datastore.*" %>
<%@ page import="java.util.List" %>

<%@include file="/header.jsp" %>

    <h1>
        Categories
        <a class="btn btn-primary btn-sm" href="/categories/add/">
            <span class="glyphicon glyphicon-plus"></span>
            Add Category
        </a>
    </h1>

    <%
    List<Entity> categories = (List<Entity>) request.getAttribute("categories");
    for (Entity category : categories) {
    %>
        <p>
        TitleEN: <strong><%= category.getProperty("titleEN") %></strong>
        </p>
    <%
    }
    %>

<%@include file="/footer.html" %>