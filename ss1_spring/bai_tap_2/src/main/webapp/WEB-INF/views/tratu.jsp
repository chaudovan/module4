<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/2/2023
  Time: 8:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Tra Từ Điển Nào</h1>
<form method="post" action="\tratu">
    <input name="keyWord" placeholder="mời nhập từ cần tra">
    <input type="submit" value="Tiêm từ">
</form>
<h2>Từ Bạn Đang Muốn Tra : ${keyWord}</h2>
</body>
</html>
