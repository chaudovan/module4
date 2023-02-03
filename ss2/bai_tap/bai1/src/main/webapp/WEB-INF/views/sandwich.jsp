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
<h1>Sandwich Condiments</h1>
<form method="post" action="/save">
    <span>
        <input type="checkbox" name="sandWich" value="Lettuce"><label>Lettuce</label>
        <input type="checkbox" name="sandWich" value="Tomato"><label>Tomato</label>
        <input type="checkbox" name="sandWich" value="Mustard"><label>Mustard</label>
        <input type="checkbox" name="sandWich" value="Sprouts"><label>Sprouts</label>
    </span><br>
    <input type="submit" value="Save">
</form>
<h2>Sandwich Condiments is : ${result}</h2>
</body>
</html>
