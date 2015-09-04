<%@ page import="java.util.List" %>

<%@include file="/header.jsp" %>

    <h1>
        <span class="glyphicon glyphicon-folder-open"></span>
        Add Possibility
    </h1>

    <div class="row">
        <div class="col-md-6">
            <form action="/possibilities/add/" method="post">
                <div class="form-group">
                    <label for="titleFR">Description FR</label>
                    <input name="titleFR" type="text" class="form-control">
                </div>
                <div class="form-group">
                    <label for="titleDE">Description DE</label>
                    <input name="titleDE" type="text" class="form-control">
                </div>
                <div class="form-group">
                    <label for="titleEN">Description EN</label>
                    <input name="titleEN" type="text" class="form-control">
                </div>
                <button type="submit" class="btn btn-primary">Add Possibility</button>
            </form>
        </div>
    </div>

<%@include file="/footer.html" %>