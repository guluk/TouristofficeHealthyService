<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.appengine.api.datastore.*" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hevs.projectcloud.touristofficebackend.models.Question" %>
<%@ page import="com.hevs.projectcloud.touristofficebackend.models.Category" %>

<%@include file="/header.jsp" %>

    <h1>
        Questions
        <a class="btn btn-primary btn-sm" href="/questions/add/">
            <span class="glyphicon glyphicon-plus"></span>
            Add Questions
        </a>
    </h1>

    <div class="row">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Category</th>
                    <th>Description</th>

                </tr>
            </thead>
            <tbody>
                <%
                List<Question> questions = (List<Question>) request.getAttribute("questions");
                if (questions.size() > 0) {
                    for (Question question : questions) {
                    %>
                        <tr>
                            <td><%= question.getQuestionId() %></td>
                            <td><%= question.getCategory().getTitle().getText("en") %></td>
                            <td><%= question.getDescription().getText("en") %></td>

                            <td>
                                <a class="btn btn-danger btn-xs" href="/questions/delete/?id=<%= question.getQuestionId() %>">
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