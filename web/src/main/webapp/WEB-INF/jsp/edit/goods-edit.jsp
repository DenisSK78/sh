<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Goods edit</title>
    <link href="${pageContext.request.contextPath}\resources\css\style.css" rel="stylesheet" type="text/css" >
</head>
<body>
<div id="main">
    <h1>Goods edit</h1>

    <sec:authorize access="hasRole('ROLE_SADMIN')">
        <a href="${pageContext.request.contextPath}/sadmin/main">Main</a><hr>
    </sec:authorize>

    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <a href="${pageContext.request.contextPath}/admin/main">Main</a><hr>
    </sec:authorize>

</div>
</body>
</html>
