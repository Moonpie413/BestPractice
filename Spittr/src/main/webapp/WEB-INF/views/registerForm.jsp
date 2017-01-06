<%--
  Created by IntelliJ IDEA.
  User: maroon
  Date: 17-1-5
  Time: 下午10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
<h1>Register</h1>
<form:form method="post" modelAttribute="user">
    Username: <form:input type="text" path="username" /><form:errors path="username"/><br/>
    Password: <form:input type="text" path="password" /><form:errors path="password" /><br/>
    <input type="submit" value="register">
</form:form>
</body>
</html>
