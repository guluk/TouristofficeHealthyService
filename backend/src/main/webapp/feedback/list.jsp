<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.appengine.api.datastore.*" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hevs.projectcloud.touristofficebackend.models.Feedback" %>

<%@include file="/header.jsp" %>

    <h1>
        Feedback
    </h1>

    <div class="row">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                </tr>
            </thead>
            <tbody>
                <%
                List<Feedback> feedbacks = (List<Feedback>) request.getAttribute("feedback");
                if (feedbacks.size() > 0) {
                    for (Feedback feedback : feedbacks) {
                    %>
                        <tr>
                            <td><%= feedback.getFeedbackId() %></td>
                            <td><%= feedback.getDescription().getText("en") %></td>
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