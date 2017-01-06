<%--
  Created by IntelliJ IDEA.
  User: maroon
  Date: 17-1-5
  Time: 下午6:42
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spittles</title>
</head>
<body>
<h1>Spittles</h1>
<ul>
    <c:forEach items="${spittleList}" var="spittle">
        <li>
            <div class="spittleMessage">
                <h3><c:out value="${spittle.message}" /></h3>
            </div>
                <span class="spittleTime"><c:out value="${spittle.time}" /></span>
                <span class="spittleLocation">
                    <c:out value="${spittle.latitude}" />
                    <c:out value="${spittle.longitude}" />
                </span>
        </li>
    </c:forEach>
</ul>
</body>
</html>
