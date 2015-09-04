<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.appengine.api.datastore.*" %>
<%@ page import="java.util.List" %>

<%@include file="/header.jsp" %>

    <h1>
        <span class="glyphicon glyphicon-list-alt"></span>
        Add Questionnaire
    </h1>

    <div class="row">
        <div class="col-md-6">
            <form action="/questionnaires/add/" method="post">
                <div class="form-group">
                    <label for="credentials">Credentials</label>
                    <input name="credentials" type="text" class="form-control" placeholder="For name John Doe, use JD">
                </div>
                <div class="form-group">
                    <label for="phone">Phone number</label>
                    <input name="phone" type="text" class="form-control" placeholder="0041 27 746 57 23">
                </div>
                <button type="submit" class="btn btn-primary">Add questionnaires</button>
            </form>
        </div>
    </div>

<%@include file="/footer.html" %>