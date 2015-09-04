<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.appengine.api.datastore.*" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hevs.projectcloud.touristofficebackend.models.Category" %>

<%@include file="/header.jsp" %>

    <h1>
        Categories
        <a class="btn btn-primary btn-sm" href="/categories/add/">
            <span class="glyphicon glyphicon-plus"></span>
            Add Category
        </a>
    </h1>

    <div class="row">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Description</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                List<Category> categories = (List<Category>) request.getAttribute("categories");
                if (categories.size() > 0) {
                    for (Category category : categories) {
                    %>
                        <tr>
                            <td><%= category.getCategoryId() %></td>
                            <td><%= category.getTitle().getText("en") %></td>
                            <td>
                                <a class="btn btn-danger btn-xs" href="/categories/delete/?id=<%= category.getCategoryId() %>">
                                    <span class="glyphicon glyphicon-trash"></span>
                                    Delete
                                </a>
                            </td>
                        </tr>
                    <%
                    }
                } else {
                %>
                    <tr>
                        <td colspan="100" class="warning">
                            No data here.
                        </td>
                    </tr>
                <%
                }
                %>
            </tbody>
        </table>
    </div>

<%@include file="/footer.html" %>