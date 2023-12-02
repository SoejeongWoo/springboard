<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <style>
        #list {
            font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #list td, #list th {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }

        #list tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        #list tr:hover {
            background-color: #ddd;
        }

        #list th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: center;
            background-color: #006bb3;
            color: white;
        }
    </style>
    <script>
        function delete_ok(id) {
            var confirm = window.confirm("정말로 삭제하겠습니까?");
            if (confirm) location.href = '/p233_22200461_3/boards/delete/' + id;
        }
    </script>
</head>
<body>
<h1>도서 목록 게시판</h1>
<table id="list" width="90%">
    <tr>
        <th>Id</th>
        <th>Category</th>
        <th>Title</th>
        <th>Writer</th>
        <th>Content</th>
        <th>Regdate</th>
        <th>Edit</th>
        <th>Delete</th>
        <th>View</th>
    </tr>

    <c:forEach items="${list}" var="u">
        <tr>
            <td>${u.id}</td>
            <td>${u.category}</td>
            <td>${u.title}</td>
            <td>${u.writer}</td>
            <td>${u.content}</td>
            <td>${u.regDate}</td>
            <td><a href="/p233_22200461_3/boards/update/${u.id}">Edit</a> </td>
            <td><a href= "javascript:delete_ok('${u.id}')">Delete</a> </td>
            <td><a href="/p233_22200461_3/boards/${u.id}">View</a></td>
        </tr>
    </c:forEach>
</table>
<br/> <a href="/p233_22200461_3/boards/add">Add New Post</a>
</body>
</html>
