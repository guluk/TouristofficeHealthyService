<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.appengine.api.datastore.*" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hevs.projectcloud.touristofficebackend.models.Possibility" %>

<%@include file="/header.jsp" %>

    <h1>
        Possibilities
        <a class="btn btn-primary btn-sm" href="/possibilities/add/">
            <span class="glyphicon glyphicon-plus"></span>
            Add Possibilitiy
        </a>
    </h1>

    <div class="row">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Description</th>
                    <th>Points</th>
                </tr>
            </thead>
            <tbody>
                <%
                List<Possibility> possibilities = (List<Possibility>) request.getAttribute("possibilities");
                for (Possibility possibility : possibilities) {
                %>
                    <tr>
                        <td><%= possibility.getPossibilityId() %></td>
                        <td><%= possibility.getDescription().getText("en") %></td>
                        <td><%= possibility.getPoints() %></td>
                    </tr>
                <%
                }
                %>
            </tbody>
        </table>
    </div>

<%@include file="/footer.html" %>