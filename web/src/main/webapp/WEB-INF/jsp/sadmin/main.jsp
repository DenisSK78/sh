<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}\resources\css\style.css" rel="stylesheet" type="text/css" >
</head>
<body>
<div id="main">
    <h1>Super admin</h1>
    <hr>
        <a href="${pageContext.request.contextPath}/edit/buy-status">Buy status</a><br><br>
        <a href="${pageContext.request.contextPath}/edit/goods-edit">Goods edit</a><br><br>
        <a href="${pageContext.request.contextPath}/edit/news-edit">News edit</a><br><br>
        <a href="${pageContext.request.contextPath}/sadmin/users">User edit</a>
    <hr>
    <a href="${pageContext.request.contextPath}/login">Login</a><br>
</div>
</body>
</html>