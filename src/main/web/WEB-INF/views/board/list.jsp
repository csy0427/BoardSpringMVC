<%--
  Created by IntelliJ IDEA.
  User: daou
  Date: 2017-09-07
  Time: 오후 4:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.Domain.Board" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>게시글 목록</title>
</head>
<body>
<div class="container">
<h2>게시글 목록</h2>
    <div class="table-responsive">
<form>
<button type="button" id="btnWrite" onclick="location.href='./write.do'">글쓰기</button>

<table class="table" border="1" width="600px">
    <thead>
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>아이디</th>
        <th>조회수</th>
    </tr>
    </thead>
    <c:forEach items="${boardList}" var="boardList" varStatus="status">
        <tbody>
        <tr>
            <td>${boardList.boardnumber}</td>
            <td><a href="${path}./read.do?boardnumber=${boardList.boardnumber}">${boardList.title}</a></td>
            <td>${boardList.id}</td>
            <td>${boardList.views}</td>
        </tr>
        </tbody>
    </c:forEach>
</table>
</form>
    </div>
</div>
</body>
</html>

