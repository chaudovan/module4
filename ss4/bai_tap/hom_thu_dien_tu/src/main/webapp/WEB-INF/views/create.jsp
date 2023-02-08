<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/2/2023
  Time: 8:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create Email</title>
</head>
<body>
<h2>Create</h2>
<form:form modelAttribute="email" action="/email/create" method="post">
    Language
    <form:select path="languages">
        <c:forEach var="language" items="${languages}">
            <form:option value="${language}">${language}</form:option>
        </c:forEach>
    </form:select><br>
    Page Size : Show
    <form:select path="pageSize">
        <c:forEach var="size" items="${size}">
            <form:option value="${size}">${size}</form:option>
        </c:forEach>
    </form:select>
    emails per page<br>
    Spam fillter :
    <form:checkbox path="spam"  value="spam"/>Spam<br>
    Signature :
    <form:textarea path="content" /><br>
    <form:button>Save</form:button>
</form:form>
</body>
</html>
