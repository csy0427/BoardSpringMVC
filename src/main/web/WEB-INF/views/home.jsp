<%--
  Created by IntelliJ IDEA.
  User: daou
  Date: 2017-09-06
  Time: 오후 1:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Home</title>
    <%@ include file="index.jsp" %>
</head>
<body>
<%@ include file="menu.jsp" %>
<c:if test="${msg == 'success'}">
    <h2>${sessionScope.id}님 환영합니다.</h2>
</c:if>
</body>
</html>
