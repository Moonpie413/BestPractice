<%--
  Created by IntelliJ IDEA.
  User: maroon
  Date: 17-1-5
  Time: 下午10:15
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>user</title>
</head>
<body>
<h1>User Info</h1>
username: <c:out value="${user.username}" />
</body>
</html>
