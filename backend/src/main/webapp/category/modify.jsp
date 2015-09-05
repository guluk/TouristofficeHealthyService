<%@ page import="java.util.List" %>
<%@ page import="com.hevs.projectcloud.touristofficebackend.models.Category" %>


<%@include file="/header.jsp" %>

    <h1>
        <span class="glyphicon glyphicon-folder-open"></span>
        Modify Category
    </h1>

    <div class="row">
        <div class="col-md-6">
        <%
            Category category = (Category) request.getAttribute("categorymodify");
        %>
            <form action="/categories/modify/" method="post">
                <div class="form-group">
                    <input type="hidden" name="id" type="text" class="form-control" value="<%= category.getCategoryId() %>">
                </div>
                <div class="form-group">
                    <label for="titleFR">Category FR</label>
                    <input name="titleFR" type="text" class="form-control" value="<%= category.getTitle().getText("fr") %>">
                </div>
                <div class="form-group">
                    <label for="titleDE">Category DE</label>
                    <input name="titleDE" type="text" class="form-control" value="<%= category.getTitle().getText("de") %>">
                </div>
                <div class="form-group">
                    <label for="titleEN">Category EN</label>
                    <input name="titleEN" type="text" class="form-control"value="<%= category.getTitle().getText("en") %>">
                </div>
                <button type="submit" class="btn btn-primary">Modify Category</button>
            </form>
        </div>
    </div>

<%@include file="/footer.html" %>