<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>News</title>
    <link href="${pageContext.request.contextPath}\resources\css\style.css" rel="stylesheet" type="text/css" >
</head>
<body>
<div id="main">
    <h1>User</h1>
    <h2>Fresh news</h2>
    <hr>
        <c:forEach var="news" items="${news}" varStatus="status">
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
            <div id="text"><p><c:out value="${news.date.toLocaleString()}"/></p></div>
            <div style="margin-left: auto; margin-right: 2em; width: 200px; height: 16px" >
                <a href="${pageContext.request.contextPath}/user/news-comment?id=${news.id}" style="font-size: 14px">
                    Обсудить сообщений: <c:out value="${news.countCommets}"/>
                </a>
            </div>
            <hr>
        </c:forEach>

    <div style="font-size: 25px; width: 200px; height: 40px; margin-left: auto; margin-right: auto; border-bottom: 15px">
        <c:if test="${page>0}">
        <a href="${pageContext.request.contextPath}/user/news/?page=${page-1}">Back</a>
        </c:if>

        <c:if test="${page<pages-1}">
        <a href="${pageContext.request.contextPath}/user/news/?page=${page+1}">Next</a>
        </c:if>
    </div>
</div>
</body>
</html>

