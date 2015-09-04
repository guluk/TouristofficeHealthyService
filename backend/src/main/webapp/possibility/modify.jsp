<%@ page import="java.util.List" %>
<%@ page import="com.hevs.projectcloud.touristofficebackend.models.Possibility" %>
<%@ page import="com.hevs.projectcloud.touristofficebackend.models.Question" %>


<%@include file="/header.jsp" %>

    <h1>
        <span class="glyphicon glyphicon-folder-open"></span>
        Add Possibility
    </h1>

    <div class="row">
        <div class="col-md-6">
        <%
            Possibility possibility = (Possibility) request.getAttribute("possibilitymodify");
        %>
            <form action="/possibilities/modify/" method="post">
                <div class="form-group">
                    <input type="hidden" name="id" type="text" class="form-control" value="<%= possibility.getPossibilityId() %>">
                </div>
                <div class="form-group">
                    <label for="descriptionFR">Description FR</label>
                    <input name="descriptionFR" type="text" class="form-control" value="<%= possibility.getDescription().getText("fr") %> ">
                </div>
                <div class="form-group">
                    <label for="descriptionDE">Description DE</label>
                    <input name="descriptionDE" type="text" class="form-control" value="<%= possibility.getDescription().getText("de") %> ">
                </div>
                <div class="form-group">
                    <label for="descriptionEN">Description EN</label>
                    <input name="descriptionEN" type="text" class="form-control" value="<%= possibility.getDescription().getText("en") %> ">
                </div>
                <div class="form-group">
                    <label for="points">Points</label>
                    <input name="points" type="text" class="form-control">
                </div>
                <div class="form-group">
                    <label for="Question">Question</label>
                    <select name="question" class="form-control">
                        <%
                        List<Question> questions = (List<Question>) request.getAttribute("questions");
                        for (Question question : questions) {
                        %>
                            <option value="<%= question.getQuestionId() %>"><%= question.getDescription().getText("en") %></option>
                        <% } %>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Modify Possibility</button>
            </form>
        </div>
    </div>

<%@include file="/footer.html" %>