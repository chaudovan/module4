<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/2/2023
  Time: 7:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Email</title>
</head>
<body>
<h3>List Email</h3>
<%--<p><a href="/email/create">Add</a></p>--%>
<table border="1">
    <tr>
        <th>ID</th>
        <th>LANGUAGE</th>
        <th>PAGESIZE</th>
        <th>SPAM</th>
        <th>CONTENT</th>
        <th>EDIT</th>
    </tr>
    <c:forEach var="email" items="${emailList}">
        <tr>
            <td>${email.id}</td>
            <td>${email.languages}</td>
            <td>${email.pageSize}</td>
            <td>${email.spam}</td>
            <td>${email.content}</td>
            <td><a href="/email/edit?id=${email.id}">edit</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
