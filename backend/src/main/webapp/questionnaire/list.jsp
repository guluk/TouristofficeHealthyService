<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.appengine.api.datastore.*" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hevs.projectcloud.touristofficebackend.models.Questionnaire" %>

<%@include file="/header.jsp" %>

    <h1>
        <span class="glyphicon glyphicon-list-alt"></span>
        Questionnaires
        <a class="btn btn-primary btn-sm" href="/questionnaires/add/">
            <span class="glyphicon glyphicon-plus"></span>
            Add Questionnaire
        </a>
        <a class="btn btn-primary btn-sm" href="/questionnaires/export/">
            <span class="glyphicon glyphicon-floppy-open"></span>
            Export Questionnaire
        </a>
    </h1>

    <div class="row">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Credentials</th>
                    <th>Phone number</th>
                    <th>Language</th>
                    <th>Date</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                List<Questionnaire> questionnaires = (List<Questionnaire>) request.getAttribute("questionnaires");
                if (questionnaires.size() > 0) {
                    for (Questionnaire questionnaire : questionnaires) {
                    %>
                        <tr onClick="location.href=('/questionnaires/view/?id=<%= questionnaire.getQuestionnaireId() %>');">
                            <td><%= questionnaire.getQuestionnaireId() %></td>
                            <td><%= questionnaire.getCredentials() %></td>
                            <td><%= questionnaire.getPhoneNumber() %></td>
                            <td><%= questionnaire.getLanguageCode() %></td>
                            <td><%= questionnaire.getDatetime() %></td>
                            <td>
                                <a class="btn btn-danger btn-xs" href="/questionnaires/delete/?id=<%= questionnaire.getQuestionnaireId() %>">
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