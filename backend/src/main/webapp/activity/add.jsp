<%@ page import="java.util.List" %>

<%@include file="/header.jsp" %>

    <h1>
        <span class="glyphicon glyphicon-folder-open"></span>
        Add Activity
    </h1>

    <div class="row">
        <div class="col-md-6">
            <form action="/activities/add/" method="post">
                <div class="form-group">
                    <label for="nameFR">Description FR</label>
                    <input name="nameFR" type="text" class="form-control">
                </div>
                <div class="form-group">
                    <label for="nameDE">Description DE</label>
                    <input name="nameDE" type="text" class="form-control">
                </div>
                <div class="form-group">
                    <label for="nameEN">Description EN</label>
                    <input name="nameEN" type="text" class="form-control">
                </div>
                <button type="submit" class="btn btn-primary">Add Activity</button>
            </form>
        </div>
    </div>

<%@include file="/footer.html" %>