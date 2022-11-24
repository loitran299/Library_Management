<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/css/readers//borrowbooks.css">
    <link rel="stylesheet" href="/css/readers//addborrow.css">
    <link rel="stylesheet" href="css/register.css">
    <title>Mượn sách</title>
</head>
<body>
<div class="container flex">
    <div class="header flex">
        <div class="page-title">Thêm ghi chú cho sách</div>
    </div>
    <div class="main flex">
        <div class="overlay" id="popup">
            <div class="content">
                <div class="register">
                    <h3>Ghi chú</h3>
                        <div class="form">
                            <div class="form-row">
                                <textarea id="textNotes" name="" id="" cols="50" rows="8"></textarea>
                            </div>
                            <div class="form-row double-btn">
                                <button class="btn-page" id="btnAddNotes">Thêm</button>
                                <button class="btn-page" id="btnClosePopup">Hủy</button>
                            </div>
                        </div>
                </div>
            </div>
        </div>
        <div class="row flex">
            <div>
                    <div class="info-item">Mã độc giả: <span>${detail.reader.code}</span></div>
                    <div class="info-item">Họ tên: <span>${detail.reader.fullName}</span></div>
            </div>
            <div class="date-picker">
                <label for="payDate">Ngày trả</label>
                    <input type="date" name="payDate" id="payDate" value="${detail.returnedDate}" readonly>
                    <input type="hidden" name="payDate" id="idCallCard" value="${detail.id}">
            </div>

        </div>
        <div class="command">
            <span>Các sách mượn</span>
        </div>
        <table class="grid">
            <thead>
            <tr>
                <th>Mã</th>
                <th>Tên sách</th>
                <th>Tình trạng</th>
                <th>Thể loại</th>
                <th>Tác giả</th>
                <th>Ghi chú</th>
                <th></th>
            </tr>
            </thead>
            <tbody id="tbody3">
            </tbody>
        </table>
        <div class="bottom">
            <a href="/receive-book" class="btn-page" id="backToReceive">Quay lại</a>
        </div>
    </div>
</div>
</body>
<script src="/js/librarian/callcardnotes.js"></script>
</html>