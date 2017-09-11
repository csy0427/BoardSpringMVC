<%--
  Created by IntelliJ IDEA.
  User: daou
  Date: 2017-09-06
  Time: 오후 4:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<a href="${path}/board/list.do">게시판</a>
<c:choose>
    <c:when test="${sessionScope.id == null}">
        <a href="${path}/member/login.do">로그인</a>
    </c:when>
    <c:otherwise>
        ${sessionScope.id}님이 로그인중입니다.
        <a href="${path}/member/logout.do">로그아웃</a>
    </c:otherwise>
</c:choose>
<hr>
