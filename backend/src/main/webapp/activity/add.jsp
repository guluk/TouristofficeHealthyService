<%@ page import="java.util.List" %>

<%@include file="/header.jsp" %>

    <h1>
        <span class="glyphicon glyphicon-tree-conifer"></span>
        Add Activity
    </h1>

    <div class="row">
        <div class="col-md-6">
            <form action="/activities/add/" method="post">
                <div class="form-group">
                    <label for="nameFR">Name FR</label>
                    <input name="nameFR" type="text" class="form-control">
                </div>
                <div class="form-group">
                    <label for="nameDE">Name DE</label>
                    <input name="nameDE" type="text" class="form-control">
                </div>
                <div class="form-group">
                    <label for="nameEN">Name EN</label>
                    <input name="nameEN" type="text" class="form-control">
                </div>
                <button type="submit" class="btn btn-primary">Add Activity</button>
            </form>
        </div>
    </div>

<%@include file="/footer.html" %>