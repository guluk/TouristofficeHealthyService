<%@ page import="java.util.List" %>
<%@ page import="com.google.appengine.api.datastore.*" %>
<%@ page import="com.hevs.projectcloud.touristofficebackend.models.Category" %>

<%@include file="/header.jsp" %>

    <h1>
        <span class="glyphicon glyphicon-folder-open"></span>
        Questions
    </h1>

    <div class="row">
        <div class="col-md-6">
            <form action="/questionnaires/add/" method="post">
                <div class="form-group">
                    <label for="titleFR">Question FR</label>
                    <input name="titleFR" type="text" class="form-control">
                </div>
                <div class="form-group">
                    <label for="titleDE">Question DE</label>
                    <input name="titleDE" type="text" class="form-control">
                </div>
                <div class="form-group">
                     <label for="titleEN">Question EN</label>
                     <input name="titleEN" type="text" class="form-control">
                 </div>

                <div class="form-group">
                    <label for="cat">Category</label>
                    <select name="cat" class="form-control">
                        <%
                        List<Category> categories = (List<Category>) request.getAttribute("categories");
                        for (Category category : categories) {
                        %>
                            <option value="<%= category.getCategoryId() %>"><%= category.getTitle().getText("en") %></option>
                        <% } %>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Add question</button>
            </form>
        </div>
    </div>

<%@include file="/footer.html" %>
