<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UsUpdute</title>
    <link href="${pageContext.request.contextPath}\resources\css\style.css" rel="stylesheet" type="text/css" >
</head>
<body>
<div id="main">
    <h1>Users Super Admin</h1>
    <h2>User update</h2>
    <div id="main_second">
        <h2>ID: <c:out value="${user.id}"/></h2>
        <a href="${pageContext.request.contextPath}/sadmin/main">Main</a><hr>
        <form action="${pageContext.request.contextPath}\PostServletAdmin" method="post" name="updateSAU">
            <label>Имя:&nbsp;</label><br><input type="text" name="name" value="${user.name}"><br>
            <label>Фамилия:&nbsp;</label><br><input type="text" name="surname" value="${user.surname}"><br>
            <label>Email:&nbsp;</label><br><input type="text" name="email" value="${user.email}"><br>
            <label>Телефон:&nbsp;</label><br><input type="text" name="phone" value="${user.phone}"><br>
            <label>Логин:&nbsp;</label><br><input type="text" name="login" value="${user.login}"><br>
            <label>Пароль:&nbsp;</label><br><input type="text" name="password" value="${user.password}"><br>
            <label>Роль:&nbsp;</label><br><input type="text" name="password" value="${user.role}"><br><br>
            <label>Информация:&nbsp;</label><br><input name="userInfo" id="userInfo" value="${user.info}"><br>
            <button type="submit">Сохранить</button>
        </form>
    </div>
</div>
</body>
</html>
