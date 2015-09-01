<%@include file="/header.jsp" %>
<%

Dim textEN, textFR, textDE

textEN=Request.Form("catEN")
textFR=Request.Form("catFR")
textDE=Request.Form("catDE")


Response.Write("textEN: "& textEN & "<br>")


%>

<%@include file="/footer.html" %>