<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.appengine.api.datastore.*" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hevs.projectcloud.touristofficebackend.models.Activity" %>

<%@include file="/header.jsp" %>

    <h1>
        Activities
        <a class="btn btn-primary btn-sm" href="/activities/add/">
            <span class="glyphicon glyphicon-plus"></span>
            Add Activity
        </a>
    </h1>

    <div class="row">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                List<Activity> activities = (List<Activity>) request.getAttribute("activities");
                if (activities.size() > 0) {
                    for (Activity activity : activities) {
                    %>
                        <tr>
                            <td><%= activity.getActivityId() %></td>
                            <td><%= activity.getName().getText("en") %></td>
                            <td>
                                <a class="btn btn-danger btn-xs" href="/activities/delete/?id=<%= activity.getActivityId() %>">
                                    <span class="glyphicon glyphicon-trash"></span>
                                    Delete
                                </a>
                                <a class="btn btn-primary btn-sm" href="/activities/modify/?id=<%= activity.getActivityId() %>">
                                    <span class="glyphicon glyphicon-trash"></span>
                                    Modify
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