<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/2/2023
  Time: 8:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <center><h2>TỜ KHAI Y TẾ</h2></center>
    <center><h5>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ
        LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</h5></center>
    <center><p style="color: red">Khuyến cáo: Khai báo thông tin sai là vi phạm phaps luật Việt Nam và có thể sử lý hình
        sự</p></center>
    <form:form modelAttribute="edit" action="/yte/edit" method="post" class="row">
        <div class="col-12">
            <label for="id" class="form-label">STT</label>
            <form:input path="id" id="id" cssClass="form-control"/>
        </div>
        <div class="col-12">
            <label for="hoTen" class="form-label">Họ và tên(IN HOA):</label>
            <form:input path="hoTen" id="hoTen" cssClass="form-control"/>
        </div>
        <div class="col-4">
            <label for="dayOfBirth" class="form-label">Năm sinh:</label>
            <form:select path="namSinnh" items="${yearInput}" cssClass="form-control" id="dayOfBirth"/>
        </div>
        <div class="col-4">
            <label for="gender" class="form-label">Giới tính:</label>
            <form:select path="gioiTinh" items="${gender}" cssClass="form-control" id="gender"/>
        </div>
        <div class="col-4">
            <label for="national" class="form-label">Quốc tịch:</label>
            <form:select path="quocTich" items="${national}" cssClass="form-control" id="national"/>
        </div>
        <div class="col-12">
            <label for="pages" class="form-label">Số hộ chiếu hoặc số CMND hoặc giấy thông hành hớp pháp khác:</label>
            <form:input path="CMND" cssClass="form-control" id="pages"/>
        </div>
        <div class="col-12">
            <p>Thông tin đi lại:</p>
            <div class="form-check form-check-inline">
                <form:radiobuttons path="loaiPhuongTien" items="${vehicle}"/>
            </div>

        </div>
        <div class="col-6">
            <label for="dayStart">Ngày khởi hành:</label>
            <div class="col-12">
                <div class="col-4" style="float: left; width: 100%">
                    <form:select path="ngayKhoiHanh" items="${dayInput}" cssClass="form-control" id="dayStart"/>
                </div>
                <div class="col-4" style="float: left; width: 100%">
                    <form:select path="thangKhoiHanh" items="${monthInput}" cssClass="form-control" id="dayStart"/>
                </div>
                <div class="col-4" style="float: left; width: 100%">
                    <form:select path="namKhoiHanh" items="${yearInput}" cssClass="form-control" id="dayStart"/>
                </div>
            </div>
        </div>
        <div class="col-6">
            <label for="dayEnd">Ngày kết thúc:</label>
            <div class="col-12">
                <div class="col-4" style="float: left; width: 100%">
                    <form:select path="ngayKetThuc" items="${dayInput}" cssClass="form-control" id="dayEnd"/>
                </div>
                <div class="col-4" style="float: left; width: 100%">
                    <form:select path="thangKetThuc" items="${monthInput}" cssClass="form-control" id="dayEnd"/>
                </div>
                <div class="col-4" style="float: left; width: 100%">
                    <form:select path="namKetThuc" items="${yearInput}" cssClass="form-control" id="dayEnd"/>
                </div>
            </div>
        </div>
        <div class="col-12">
            <label for="floatingTextarea">Trong vòng 14 ngày qua Anh/Chị có đến tỉnh/thành phố nào?</label>
            <div for="floatingTextarea" class="form-floating">
                <form:textarea path="diLai" id="floatingTextarea" cssClass="form-control"/>
            </div>
        </div>
        <div class="col-12">
            <label for="address" class="form-label">Địa chỉ liên lạc:</label>
            <form:input path="diaChi" cssClass="form-control" id="address"/>
        </div>
        <div class="col-12">
            <label for="phone" class="form-label">Số điện thoại liên lạc:</label>
            <form:input path="dienThoai" cssClass="form-control" id="phone"/>
        </div>
        <div class="col-12">
            <label for="email" class="form-label">Email:</label>
            <form:input path="email" cssClass="form-control" id="email"/>
        </div>
        <div>
            <button type="submit">Gửi tờ khai</button>
        </div>
    </form:form>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
