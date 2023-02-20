<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/2/2023
  Time: 8:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create Email</title>
</head>
<body>
<h2>Create</h2>
<form:form modelAttribute="emailEdit" action="/email/edit" method="post">
    <table>
        <tr>
            <td><form:hidden path="id"/></td>
        </tr>
        <tr>
            <td>languages:</td>
            <td><form:select path="languages" items="${languages}"/></td>
        </tr>
        <tr>
            <td>Pages size:</td>
            <td>
                <span>Show</span>
                <form:select path="pageSize" items="${size}"/>
                <span>email per page</span>
            </td>
        </tr>
        <tr>
            <td>Spams filter:</td>
            <td>
                <form:checkbox path="spam"/>
                <span>Enable spams filter</span>
            </td>
        </tr>
        <tr>
            <td>Signature:</td>
            <td><form:textarea path="content"/></td>
        </tr>
        <tr>
            <td></td>
            <td><form:button>Edit</form:button></td>
        </tr>
    </table>
</form:form>
</body>
</html>
