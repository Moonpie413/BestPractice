<%--
  Created by IntelliJ IDEA.
  User: maroon
  Date: 17-1-5
  Time: 下午9:05
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spittle</title>
</head>
<body>
<h3>spittle Message</h3>
<p><c:out value="${spittle.message}"/></p>
<h3>spittle Time</h3>
<p><c:out value="${spittle.time}" /></p>
</body>
</html>
