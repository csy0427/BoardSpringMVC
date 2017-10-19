<%--
  Created by IntelliJ IDEA.
  User: daou
  Date: 2017-09-07
  Time: 오후 4:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시글 읽기</title>
</head>
<body>
<h2>게시글 읽기</h2>
<form name="form1" method="post" action="/board/update.do">
    <div>
        조회수 : ${post.views}
    </div>
    <div>
        제목
        <form name="title" id="title" size="80" value="${post.title}"/>
    </div>
    <div>
        내용
        <form name="content" id="content" rows="4" cols="80" >${post.content}</form>
    </div>
    <div>
        아이디
        ${id}
    </div>
    <div>
        첨부파일
        <c:if test="${file != null}">
        <form name="file" id="file" value="${file}"/>
        </c:if>
    </div>
    <div style="width:650px; text-align: center;">
        <input type="hidden" name="boardnumber" value="${post.boardnumber}">
        <button type="submit">수정</button>
        <input type="button" value="삭제" onclick="location.href='./delete.do?boardnumber=${post.boardnumber}'">
    </div>
</form>
</body>
</html>
