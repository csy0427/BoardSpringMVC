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
    <script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="../js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="../js/jquery.fileupload.js"></script>
    <script>
        function fileSubmit() {
            var formData = new FormData($("#fileForm")[0]);
            $.ajax({
                type : 'post',
                url : 'upload',
                data : formData,
                processData : false,
                contentType : false,
                success : function() {
                    alert("파일 업로드하였습니다.");
                },
                error : function(error) {
                    alert("파일 업로드에 실패하였습니다.");
                    console.log(error);
                    console.log(error.status);
                }
            });
        }
    </script>

    <title>게시글 작성</title>
</head>
<body>
<h2>게시글 작성</h2>
<form name="fileForm" method="post" onclick="fileSubmit();" enctype="multipart/form-data">
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
        <!--<input name="id" id="id" placeholder="아이디를 입력해주세요">-->
        ${id}
    </div>
    <div style="width:650px; text-align: center;">
        <input type="submit" value="제출">
        <button type="reset">취소</button>
    </div>
    <div>
        <input id="imageUpload" type="file" name="file"  multiple="">
        <br>
    </div>
</form>

</body>
