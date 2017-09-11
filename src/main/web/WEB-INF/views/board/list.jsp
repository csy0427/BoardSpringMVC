<%@ page import="com.Domain.Board" %>
<%@ page import="java.util.List" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: daou
  Date: 2017-09-07
  Time: 오후 4:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>게시글 목록</title>
</head>
<body>
<h2>게시글 목록</h2>
<form>
<button type="button" id="btnWrite" onclick="location.href='./write.do'">글쓰기</button>
<table border="1" width="600px">
    <tr align="center">
        <th>번호</th>
        <th>제목</th>
        <th>아이디</th>
        <th>조회수</th>
    </tr>
    <c:forEach items="${boardList}" var="boardList" >
        <tr align="center">
            <td>${boardList.boardnumber}</td>
            <td><a href="${path}./board/read.do?boardnumber=${boardList.boardnumber}">${boardList.title}</a></td>
            <td>${boardList.id}</td>
            <td>${boardList.views}</td>
        </tr>
    </c:forEach>
</table>
</form>
</body>
</html>

