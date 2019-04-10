<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UsersSupAdmin</title>
    <link href="${pageContext.request.contextPath}\resources\css\style.css" rel="stylesheet" type="text/css" >
</head>
<body>
<div id="main">
    <h1>Users Super Admin</h1>
    <a href="${pageContext.request.contextPath}/sadmin/main">Main</a><hr>
    <form action="${pageContext.request.contextPath}/usersSA" method="post">
        <table class="table">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Email</th>
                <th>UserLogin</th>
                <th>UserRole</th>
                <th>Delete</th>
                <th>Update</th>
            </tr>
            <c:forEach var="users" items="${users}">
                <tr>
                    <td><c:out value="${users.id}"/></td>
                    <td><c:out value="${users.name}"/></td>
                    <td><c:out value="${users.surname}"/></td>
                    <td><c:out value="${users.email}"/></td>
                    <td><c:out value="${users.login}"/></td>
                    <td><c:out value="${users.role}"/></td>
                    <%------------------------------delete fix this link--------------------------------------------%>
                    <td><a href="${pageContext.request.contextPath}/">Delete</a></td>
                    <td><a href="${pageContext.request.contextPath}/sadmin/user-update?id=${users.id}">Update</a></td>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>
</body>
</html>
