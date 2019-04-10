<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>News edit</title>
    <link href="${pageContext.request.contextPath}\resources\css\style.css" rel="stylesheet" type="text/css" >
</head>
<body>
<div id="main">
    <h1>News update</h1><div id="msg">${msg}</div>
        <a href="${pageContext.request.contextPath}/edit/news-edit">Go back</a><hr>
    <div id="text"><h3>${newsDTO.name}- id: ${newsDTO.id}</h3></div>
    <hr>

    <c:if test="${newsDTO.id eq newsDTO.pics}">
        <form:form method="POST" action="${pageContext.request.contextPath}/edit/news-update/del-pics" enctype="multipart/form-data">
        <div id="pics">
            <img src="${pageContext.request.contextPath}/resources/pics/${newsDTO.id}.jpg"
                 width="300" height="200"/>
        </div>
        <div><button name="del" type="submit" value="${newsDTO.id}">Delete picsssss</button></div>
        </form:form>
    </c:if>

    <c:if test="${newsDTO.id ne newsDTO.pics}">
        <form:form method="POST" action="${pageContext.request.contextPath}/edit/news-update/add-pics" enctype="multipart/form-data">
        <div><input type="file" style="width: 500px" name="file"/></div>
        <div><button name="add" type="submit" value="${newsDTO.id}">Add picsssssss</button></div>
        </form:form>
    </c:if>

    <br><br>
    <form:form method="POST" action="${pageContext.request.contextPath}/edit/news-update" enctype="multipart/form-data">
        <input name="name" type="text" value="${newsDTO.name}"><br><br>
        <textarea  name="text" rows="6" cols="135" style="margin-left: 10px">${newsDTO.text}</textarea><br><br>
        <input name="author" type="text" value="${newsDTO.author}"><br><br>
        <button name="newsId" value="${newsDTO.id}" type="submit">Update</button>
        <div id="text"><p><c:out value="${newsDTO.date}"/></p></div>
    <hr>
    </form:form>

    <div id="text">
        <c:forEach var="news" items="${newsDTO.commentList}" varStatus="status">
            <p style="font-size: small"><c:out value="${news.comment}"/>
            <p style="font-size: small"><c:out value="${news.date.toLocaleString()}"/>
                <c:out value="${news.idUser}"/></p>
            <div><a href="${pageContext.request.contextPath}/edit/news-update/delete?id=${newsDTO.id}&com=${news.id}">Delete</a></div>

            <hr>
        </c:forEach>
    </div>
</div>
</body>
</html>
