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
                    <label for="descriptionFR">Description FR</label>
                    <input name="descriptionFR" type="text" class="form-control">
                </div>
                <div class="form-group">
                    <label for="descriptionDE">Description DE</label>
                    <input name="descriptionDE" type="text" class="form-control">
                </div>
                <div class="form-group">
                    <label for="descriptionEN">Description EN</label>
                    <input name="descriptionEN" type="text" class="form-control">
                </div>
                <div class="form-group">
                    <label for="points">Points</label>
                    <input name="points" type="text" class="form-control">
                </div>
                <button type="submit" class="btn btn-primary">Add Possibility</button>
            </form>
        </div>
    </div>

<%@include file="/footer.html" %>