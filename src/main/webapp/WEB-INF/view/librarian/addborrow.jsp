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
    <link rel="stylesheet" href="/css/combobox.css">
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
                <div class="info-item" id="readerCode">Mã độc giả: <span></span></div>
                <div class="info-item" id="readerName">Họ tên: <span></span></div>
                <div class="combobox" id="combobox" urls="http://localhost:8080/api/readers">
                    <input type="text" id="comboboxValue">
                    <div class="list-values" id="list">
                    </div>
                </div>
            </div>
            <div class="date-picker">
                <label for="payDate">Ngày trả</label>
                <c:if test="${detail != null}">
                    <input type="date" name="payDate" id="payDate" value="${detail.returnedDate}">
                </c:if>
                <c:if test="${detail == null}">
                    <input type="date" name="payDate" id="payDate">
                </c:if>
            </div>

        </div>
        <div class="command">
            <span>Các sách mượn</span>
            <c:if test="${detail == null}">
                <a href="/add-books" class="btn-page">Thêm sách</a>
            </c:if>
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
            <a href="/book-management" class="btn-page" id="backToBorrowBook">Quay lại</a>
            <c:if test="${detail == null}">
                <a class="btn-page" id="btnAddBorrow">Đăng ký</a>
            </c:if>
            <%--            <a class="btn-page" id="btnAddBorrow">Đăng ký</a>--%>
        </div>
    </div>
</div>
</body>
<script src="/js/combobox.js"></script>
<script src="/js/librarian/addborrow.js"></script>
</html>