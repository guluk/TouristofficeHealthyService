<!DOCTYPE html>
<html>
<head>
    <title>Welcome to TOHSA admin</title>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="style.css">

    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

    <!-- Libraries for chart -->
    <script src="http://d3js.org/d3.v3.min.js"></script>
    <script src="/script/RadarChart.js"></script>
</head>

<body role="document" style="padding-top: 70px;">
    <!-- menu for navigate  -->
    <%@include file="/menu.html" %>

    <!-- container-->
    <div class="container theme-showcase" role="main">
        <h1>Welcome to TOHSA admin</h1>

        <!-- Graph container -->
        <div id="body">
            <div id="chart"></div>
        </div>

        <!-- Graph script -->
        <script type="text/javascript" src="script.jsp"></script>
    </div>
</body>
</html>
