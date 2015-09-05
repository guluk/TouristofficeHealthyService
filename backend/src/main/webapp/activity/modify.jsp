<%@ page import="java.util.List" %>
<%@ page import="com.hevs.projectcloud.touristofficebackend.models.Activity" %>


<%@include file="/header.jsp" %>

    <h1>
        <span class="glyphicon glyphicon-tree-conifer"></span>
        Modify Activity
    </h1>

    <div class="row">
        <div class="col-md-6">
         <%
            Activity activity = (Activity) request.getAttribute("activitymodify");
         %>
            <form action="/activities/modify/" method="post">
                <div class="form-group">
                    <input type="hidden" name="id" type="text" class="form-control" value="<%= activity.getActivityId() %>">
                </div>
                <div class="form-group">
                    <label for="nameFR">Name FR</label>
                    <input name="nameFR" type="text" class="form-control" value="<%= activity.getName().getText("fr") %> ">
                </div>
                <div class="form-group">
                    <label for="nameDE">Name DE</label>
                    <input name="nameDE" type="text" class="form-control"value="<%= activity.getName().getText("de") %> ">
                </div>
                <div class="form-group">
                    <label for="nameEN">Name EN</label>
                    <input name="nameEN" type="text" class="form-control"value="<%= activity.getName().getText("en") %> ">
                </div>
                <button type="submit" class="btn btn-primary">Modify Activity</button>
            </form>
        </div>
    </div>

<%@include file="/footer.html" %>