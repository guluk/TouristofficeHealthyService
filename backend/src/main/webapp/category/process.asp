<%@ Language="VBscript" %>
<html>
<head>
<title>Submitted data</title>
</head>

<body>
<%

Dim textEN, textFR, textDE

textEN=Request.Form("catEN")
textFR=Request.Form("catFR")
textDE=Request.Form("catDE")


Response.Write("textEN: "& textEN & "<br>")


%>

</body>
</html>