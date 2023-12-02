<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
<h1>게시글 수정</h1>

<form action="/p233_22200461_3/boards/update/${board.id}" method="POST">
    <label for="title">제목:</label>
    <input type="text" id="title" name="title" value=${board.title} />
    <br>
    <label for="content">내용:</label>
    <input type="textarea" id="content" name="content" value=${board.content} />
    <br>
    <label for="writer">작가:</label>
    <input type="textarea" id="writer" name="writer" value=${board.writer} />
    <br>
    <label for="category">카테고리:</label>
    <input type="textarea" id="category" name="category" value=${board.category} />
    <br>
    <input type="submit" value="수정">
</form>
</body>
</html>
