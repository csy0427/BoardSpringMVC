<%--
  Created by IntelliJ IDEA.
  User: daou
  Date: 2017-09-08
  Time: 오후 3:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>게시글 작성</title>
</head>
<body>
<h2>게시글 작성</h2>
<form name="form1" method="post" action="${path}/board/add.do">
    <div>
        제목
        <input name="title" id="title" size="80" placeholder="제목을 입력해주세요">
    </div>
    <div>
        내용
        <textarea name="content" id="content" rows="4" cols="80" placeholder="내용을 입력해주세요"></textarea>
    </div>
    <div>
        아이디
        <input name="id" id="id" placeholder="아이디를 입력해주세요">
    </div>
    <div style="width:650px; text-align: center;">
        <input type="submit" value="제출">
        <button type="reset">취소</button>
    </div>
</form>
</body>
