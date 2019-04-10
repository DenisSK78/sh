<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Login</title>
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <%--My--%>
    <link href="${pageContext.request.contextPath}\resources\css\style.css" rel="stylesheet" type="text/css" >
</head>
<body>
<div class="container-fluid">
    <div id="login-error">
        <c:if test="${param.error != null}">
            <div class="alert alert-danger">
                <p style="text-align: center">Invalid username or password.</p>
            </div>
        </c:if>
    </div>
    <div class="row center-block">
        <div class="col-md-5"></div>
        <div class="col-md-2">
            <form action="${pageContext.request.contextPath}/login" method="post">
                <div class="form-group">
                    <label for="login">Login</label>
                    <input type="text" class="form-control" id="login" value="<c:out value="${loginObject.login}"/>" name="login" placeholder="Login">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" value="<c:out value="${loginObject.password}"/>" name="password" placeholder="Password">
                </div>
                <button type="submit">Login</button>
            </form>
        </div>
        <div class="col-md-5"></div>
    </div>
</div>

</body>
</html>
