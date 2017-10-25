<%@ page import="com.Domain.File" %>
<%@ page import="com.Domain.Board" %><%--
  Created by IntelliJ IDEA.
  User: daou
  Date: 2017-09-07
  Time: 오후 4:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>  <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script type="text/javascript">

    </script>
   <%
       Board board=(Board)session.getAttribute("post");
       File file=(File)session.getAttribute("file");
   %>
    <title>게시글 읽기</title>
</head>
<body>
<h2>게시글 읽기</h2>
<form name="form1" method="post" action="/board/updateForm.do">
    <table class="table" border="1" width="400px">
    <tr>
        <td>조회수 : ${post.views}
    </tr>
    <tr>
        <td>제목 : <%=board.getTitle()%>
    </tr>
    <tr>
        <td>내용</td>
    </tr>
        <tr>
            <td><%=board.getContent()%></td>
        </tr>
        <tr>
        <td>아이디 : ${id}</td>
    </tr>
        <tr>
            <td>첨부파일
                <div style="color: blue" />
                <a href="./downloadFile.do?filename=<%=file.getFileName()%>"><%=file.getFileName()%></a></td>
        </tr>
    </table>

    <div style="width:650px; text-align: center;">
        <input type="hidden" name="views" value="${post.views}">
        <input type="hidden" name="boardnumber" value="${post.boardnumber}">
        <input type="hidden" name="content" value="${post.content}">
        <input type="hidden" name="title" value="${post.title}">
        <input type="submit" value="수정">
        <input type="button" value="삭제" onclick="location.href='./delete.do?boardnumber=<%=board.getBoardnumber()%>'">
    </div>
</form>
</body>
</html>
