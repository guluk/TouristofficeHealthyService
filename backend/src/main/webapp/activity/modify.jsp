<%@ page import="java.util.List" %>
<%@ page import="com.hevs.projectcloud.touristofficebackend.models.Activity" %>


<%@include file="/header.jsp" %>

    <h1>
        <span class="glyphicon glyphicon-folder-open"></span>
        Add Activity
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
                    <label for="nameFR">Description FR</label>
                    <input name="nameFR" type="text" class="form-control" value="<%= activity.getName().getText("fr") %> ">
                </div>
                <div class="form-group">
                    <label for="nameDE">Description DE</label>
                    <input name="nameDE" type="text" class="form-control"value="<%= activity.getName().getText("de") %> ">
                </div>
                <div class="form-group">
                    <label for="nameEN">Description EN</label>
                    <input name="nameEN" type="text" class="form-control"value="<%= activity.getName().getText("en") %> ">
                </div>
                <button type="submit" class="btn btn-primary">Modify Activity</button>
            </form>
        </div>
    </div>

<%@include file="/footer.html" %>