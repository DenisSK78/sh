
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Comment</title>
    <link href="${pageContext.request.contextPath}\resources\css\style.css" rel="stylesheet" type="text/css" >
</head>
<body>
<div id="main">
    <h1>News</h1>
    <hr>

        <c:if test="${news.id eq news.pics}">
            <div id="pics">
                <img src="${pageContext.request.contextPath}/resources/pics/${news.id}.jpg"
                     width="300" height="200"/>
            </div>
        </c:if>
        <br>

        <div id="text"><h4><c:out value="${news.name}"/></h4></div>
        <div id="text"><p><c:out value="${news.text}"/></p></div><br>
        <div id="text"><p><c:out value="${news.author}"/></p></div>
        <div id="text"><p><c:out value="${news.date}"/></p></div>
        <hr>

    <div id="text">
    <c:forEach var="news" items="${news.commentList}" varStatus="status">
        <p style="font-size: small"><c:out value="${news.comment}"/></p>
        <p style="font-size: small"><c:out value="${news.date.toLocaleString()}"/>
<%---------%>
            <c:out value="${news.idUser}"/></p><hr>
    </c:forEach>
    </div>

    <div id="text">
    <form:form method="post" action="${pageContext.request.contextPath}/user/news-commentPost">

        <textarea name="comment" id="comment" cols="135" rows="3"></textarea><br>
    <button type="submit">New comment</button>
    </form:form>
    </div>

</div>
</body>
</html>

<%--<c:out value="${comment}"/>--%>
<%--<form:textarea path="comment"/>--%>