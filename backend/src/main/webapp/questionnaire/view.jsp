<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.appengine.api.datastore.*" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hevs.projectcloud.touristofficebackend.models.Questionnaire" %>
<%@ page import="com.hevs.projectcloud.touristofficebackend.models.Category" %>

<%@include file="/header.jsp" %>

    <h1>
        <span class="glyphicon glyphicon-list-alt"></span>
        Questionnaire
    </h1>

        <div class="row">
            <div class="col-md-6">
                <table class="table table-striped">
                    <tbody>
                        <% Questionnaire questionnaire = (Questionnaire) request.getAttribute("questionnaire"); %>

                        <tr>
                            <th>Id</th>
                            <td><%= questionnaire.getQuestionnaireId() %></td>
                        </tr>
                        <tr>
                            <th>Credentials</th>
                            <td><%= questionnaire.getCredentials() %></td>
                        </tr>
                        <tr>
                            <th>Phone number</th>
                            <td><%= questionnaire.getPhoneNumber() %></td>
                        </tr>
                        <tr>
                            <th>Language</th>
                            <td><%= questionnaire.getLanguageCode() %></td>
                        </tr>
                        <tr>
                            <th>Date</th>
                            <td><%= questionnaire.getDatetime() %></td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="col-md-6">
                <!-- Graph container -->
                <div id="chart"></div>

                <!-- Graph script -->
                <script>
                    var d = [
                        [
                            <%
                            List<Category> categories = (List<Category>) request.getAttribute("categories");

                            if(categories != null) {
                                for (Category category : categories) {
                                %>
                                    {axis:'<%= category.getTitle().getText("en") %>',value:0.59},
                                <%
                                }
                            }
                            %>

                            {axis:"Email",value:0.59},
                            {axis:"Social Networks",value:0.56},
                            {axis:"View Shopping sites",value:0.14},
                            {axis:"Online Gaming",value:0.12},
                            {axis:"Navigation",value:0.27},
                            {axis:"Photo Video",value:0.4},
                            {axis:"Reading",value:0.03},
                            {axis:"Listen Radio",value:0.07},
                            {axis:"Sending Money",value:0.18},
                            {axis:"Use less Once week",value:0.08}
                        ]
                    ];
                </script>
                <script type="text/javascript" src="/questionnaire/script.js"></script>
            </div>
        </div>

<%@include file="/footer.html" %>