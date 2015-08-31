<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.appengine.api.datastore.*" %>
<%@ page import="java.util.List" %>

<%@include file="/header.jsp" %>

    <h1>
        <span class="glyphicon glyphicon-list-alt"></span>
        Questionnaires
        <a class="btn btn-primary btn-sm" href="/questionnaire/new">
            <span class="glyphicon glyphicon-plus"></span>
            Add Questionnaire
        </a>
    </h1>

    <div class="row">
        <div class="col-md-6">
            <form action="/questionnaires/post" method="post">
                <div class="form-group">
                    <label for="test2">Credentials</label>
                    <input name="test1" type="text" class="form-control" placeholder="For name John Doe, use JD">
                </div>
                <div class="form-group">
                    <label for="test2">Phone number</label>
                    <input name="test2" type="text" class="form-control" placeholder="0041 27 746 57 23">
                </div>
                <button type="submit" class="btn btn-primary">Create questionnaires</button>
            </form>
        </div>

        <div class="col-md-6">
            <!-- Graph container -->
            <div id="body">
                <div id="chart"></div>
            </div>

            <!-- Graph script -->
            <script>
                var d = [
                    [
                        <%
                        List<Entity> categories = (List<Entity>) request.getAttribute("categories");
                        if(categories != null) {
                        for (Entity category : categories) {
                        %>
                            {axis:'<%= category.getProperty("title") %>',value:0.59},
                        <%
                        } }
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
            <script type="text/javascript" src="/script.jsp"></script>
        </div>
    </div>

    <h2>From datastore</h2>

    <div class="row">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Credentials</th>
                    <th>Phone number</th>
                    <th>Language</th>
                    <th>Date</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Entity> questionnaires = (List<Entity>) request.getAttribute("questionnaires");
                    for (Entity questionnaire : questionnaires) {
                %>
                <tr>
                    <td><%= questionnaire.getProperty("id") %></td>
                    <td><%= questionnaire.getProperty("credentials") %></td>
                    <td><%= questionnaire.getProperty("phoneNumber") %></td>
                    <td><%= questionnaire.getProperty("languageCode") %></td>
                    <td><%= questionnaire.getProperty("datetime") %></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>

<%@include file="/footer.html" %>