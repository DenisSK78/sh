<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}\resources\css\style.css" rel="stylesheet" type="text/css" >
</head>
<body>
<div id="main">
    <%--<div id="main_second">--%>
    <h1>Shop academy</h1>
    <a href="${pageContext.request.contextPath}/user/registration">User Registration</a><br>
    <a href="${pageContext.request.contextPath}/user/news">News</a><br>
        <hr>
    <a href="${pageContext.request.contextPath}/admin/users">Users Admin</a><br>
        <hr>
    <a href="${pageContext.request.contextPath}/sadmin/users">Users Super Admin</a><br>
        <hr>
    <a href="${pageContext.request.contextPath}/login">Login</a><br>

    <%--</div>--%>
</div>
</body>
</html>
