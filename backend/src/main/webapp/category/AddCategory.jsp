<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>

<%@include file="/header.jsp" %>

    <h1>
        Categories
    </h1>



    <form method="POST" action="/process">
    Categorie FR:<br>
    <input type ="text" name="catFR">
    <br>
     Categorie EN:<br>
        <input type ="text" name="catEN">
        <br>
         Categorie DE:<br>
            <input type ="text" name="catDE">
        <br>
        <input type="submit" value="ajouter">
     </form>


<%@include file="/footer.html" %>