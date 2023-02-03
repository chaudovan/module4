<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/2/2023
  Time: 12:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Caculator</h1>
<form method="post" action="/caculator">
    <span>
        <input type="number" name="num1" value="${num1}">
        <input type="number" name="num2" value="${num2}">
    </span><br>
    <span>
        <button name="operator" value="ADDITION">ADDITION(+)</button>
        <button name="operator" value="SUBTRACTION">SUBTRACTION(-)</button>
        <button name="operator" value="MUTIPLICATION">MUTIPLICATION(X)</button>
        <button name="operator" value="DIVISION">DIVISION(/)</button>
    </span>
</form>
<h2>Reuslt Division: ${result}</h2>
</body>
</html>
