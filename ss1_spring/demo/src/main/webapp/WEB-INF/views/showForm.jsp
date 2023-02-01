<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 13/1/2023
  Time: 8:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/usd">
    <label>Nhập usd</label>
    <input name="usd" type="text" value="0"><br>
    <label>Rate</label>
    <input name="rate" value="22000" type="text" readonly><br>
    <input type="submit" value="Tính">
</form>
</body>
</html>
