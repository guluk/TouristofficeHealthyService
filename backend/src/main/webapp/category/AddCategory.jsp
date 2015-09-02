<%@ page import="java.util.List" %>

<%@include file="/header.jsp" %>

    <h1>
        <span class="glyphicon glyphicon-folder-open"></span>
        Categories
    </h1>

    <div class="row">
        <div class="col-md-6">
            <form action="/process" method="post">
                <div class="form-group">
                    <label for="catFR">Category FR</label>
                    <input name="catFR" type="text" class="form-control">
                </div>
                <div class="form-group">
                    <label for="catEN">Category EN</label>
                    <input name="catEN" type="text" class="form-control">
                </div>
                <div class="form-group">
                    <label for="catDE">Category EN</label>
                    <input name="catDE" type="text" class="form-control">
                </div>
                <button type="submit" class="btn btn-primary">Add Category</button>
            </form>
        </div>
    </div>

<%@include file="/footer.html" %>