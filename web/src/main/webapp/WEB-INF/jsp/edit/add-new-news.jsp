<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>News edit</title>
    <link href="${pageContext.request.contextPath}\resources\css\style.css" rel="stylesheet" type="text/css" >
</head>
<body>
<div id="main">
    <h1>Add news</h1><div id="msg">${msg}</div>
    <a href="${pageContext.request.contextPath}/edit/news-edit">Go back</a><hr>



    <form:form method="POST" action="${pageContext.request.contextPath}/edit/add-new-news/upload" enctype="multipart/form-data">


        <label>Name:&nbsp;</label><br>
            <input type="text" name="name" value="${newsDTO}"><br>
        <label>Article:&nbsp;</label><br>
        <textarea type="text" name="text" value="${newsDTO}" rows="4" cols="100" style="margin-left: 10px"></textarea><br>
        <label>Author:&nbsp;</label><br>
            <input type="text" name="author" value="${newsDTO}"><br>

        <br>
        <label>Select a file to upload</label><br>
        <div><input type="file" style="width: 500px" name="file"/></div>

        <button type="submit">Save</button><br>
    </form:form>

</div>
</body>
</html>
