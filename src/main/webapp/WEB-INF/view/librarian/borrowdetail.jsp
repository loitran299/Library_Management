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
    <title>Mượn sách</title>
</head>
<body>
<div class="container flex">
    <div class="header flex">
        <div class="page-title">Thêm phiếu mượn</div>
    </div>
    <div class="main flex">
        <div class="row flex">
            <div>
                <c:if test="${detail != null}">
                    <div class="info-item">Mã độc giả: <span>${detail.reader.code}</span></div>
                    <div class="info-item">Họ tên: <span>${detail.reader.fullName}</span></div>
                </c:if>
                <c:if test="${detail == null}">
                    <div class="info-item">Mã độc giả: <span></span></div>
                    <div class="info-item">Họ tên: <span></span></div>
                </c:if>
            </div>
            <div class="date-picker">
                <label for="payDate">Ngày trả</label>
                <c:if test="${detail != null}">
                    <input type="date" name="payDate" id="payDate" value="${detail.returnedDate}">
                    <input type="hidden" name="payDate" id="idCallCard" value="${detail.id}">
                </c:if>
                <c:if test="${detail == null}">
                    <input type="date" name="payDate" id="payDate">
                </c:if>
            </div>

        </div>
        <div class="command">
            <span>Các sách mượn</span>
                <a href="add-books" class="btn-page">Thêm sách</a>
        </div>
        <table class="grid">
            <thead>
            <tr>
                <th>Mã</th>
                <th>Tên sách</th>
                <th>Tình trạng</th>
                <th>Thể loại</th>
                <th>Tác giả</th>
                <th></th>
            </tr>
            </thead>
            <tbody id="tbody3">
            <c:if test="${detail != null}">
                <c:forEach items="${detail.books}" var="book">
                    <tr>
                        <td>${book.code}</td>
                        <td>${book.title.name}</td>
                        <td>${book.status}</td>
                        <td>${book.title.category.name}</td>
                        <td>${book.title.author.name}</td>
                        <td>
                            <a href="/book-detail?id=${book.id}">Chi tiết</a>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
            </tbody>
        </table>
        <div class="bottom">
            <a href="/receive-book" class="btn-page" id="backToReceive">Quay lại</a>
                <a class="btn-page" id="btnAddBorrow">Lưu</a>
        </div>
    </div>
</div>
</body>
<script src="/js/librarian/borrowdetail.js"></script>
</html>