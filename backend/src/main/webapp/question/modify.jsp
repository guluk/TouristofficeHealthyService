<%@ page import="java.util.List" %>
<%@ page import="com.google.appengine.api.datastore.*" %>
<%@ page import="com.hevs.projectcloud.touristofficebackend.models.Question" %>
<%@ page import="com.hevs.projectcloud.touristofficebackend.models.Category" %>


<%@include file="/header.jsp" %>

    <h1>
        <span class="glyphicon glyphicon-folder-open"></span>
        Questions
    </h1>

    <div class="row">
        <div class="col-md-6">
         <%
            Question question = (Question) request.getAttribute("questionmodify");
         %>
            <form action="/questions/modify/" method="post">
                <div class="form-group">
                    <input type="hidden" name="id" type="text" class="form-control" value="<%= question.getQuestionId() %>">
                </div>
                <div class="form-group">
                    <label for="titleFR">Question FR</label>
                    <input name="titleFR" type="text" class="form-control" value="<%= question.getDescription().getText("fr") %> ">
                </div>
                <div class="form-group">
                    <label for="titleDE">Question DE</label>
                    <input name="titleDE" type="text" class="form-control" value="<%= question.getDescription().getText("de") %> ">
                </div>
                <div class="form-group">
                     <label for="titleEN">Question EN</label>
                     <input name="titleEN" type="text" class="form-control" value="<%= question.getDescription().getText("en") %> ">
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
                <button type="submit" class="btn btn-primary">Modify question</button>
            </form>
        </div>
    </div>

<%@include file="/footer.html" %>
