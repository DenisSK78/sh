<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>News edit</title>
    <link href="${pageContext.request.contextPath}\resources\css\style.css" rel="stylesheet" type="text/css" >
</head>
<body>
<div id="main">
    <h1>News edit</h1><div id="msg">${msg}</div>
    <sec:authorize access="hasRole('ROLE_SADMIN')">
        <a href="${pageContext.request.contextPath}/sadmin/main">Main</a><hr>
    </sec:authorize>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <a href="${pageContext.request.contextPath}/admin/main">Main</a><hr>
    </sec:authorize>

    <a href="${pageContext.request.contextPath}/edit/add-new-news">Add new news</a><br><br>
        <form action="${pageContext.request.contextPath}/edit/news-edit" method="post">
            <table class="table">
                <th>id</th>
                <th>name</th>
                <th>date</th>
                <th>pics</th>
                <th>author</th>
                <th>update</th>
                <th>delete</th>
                    <c:forEach var="news" items="${newsDTO}">
                        <tr>
                            <td><c:out value="${news.id}"/></td>
                            <td><c:out value="${news.name}"/></td>
                            <td><c:out value="${news.date.toLocaleString()}"/></td>
                            <td><c:out value="${news.pics}"/></td>
                            <td><c:out value="${news.author}"/></td>
                            <td><a href="${pageContext.request.contextPath}/edit/news-update?id=${news.id}">update</a></td>
                            <td><a href="${pageContext.request.contextPath}/edit/news-edit?delete=${news.id}">delete</a></td>
                        </tr>
                    </c:forEach>
            </table>
        </form>
</div>
</body>
</html>
