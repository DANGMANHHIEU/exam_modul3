<%--
  Created by IntelliJ IDEA.
  User: Ritakool
  Date: 18/05/2023
  Time: 10:46 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
    <meta charset="UTF-8">
</head>
<body>
<center>
    <h1>Nhân viên</h1>
    <h2>
        <a href="/add">Thêm nhân viên</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Danh sách nhân viên </h2></caption>
        <tr>
            <th>Mã nhân viên</th>
            <th>Họ và tên</th>
            <th>Email</th>
            <th>Địa chỉ</th>
            <th>SĐT</th>
            <th>Lương</th>
            <th>Phân loại</th>
            <th>Thao tác</th>
        </tr>
        <c:forEach var="staff" items="${listStaff}">
            <tr>
                <td><c:out value="${staff.id}"/></td>
                <td><c:out value="${staff.name}"/></td>
                <td><c:out value="${staff.email}"/></td>
                <td><c:out value="${staff.address}"/></td>
                <td><c:out value="${staff.phoneNumber}"/></td>
                <td><c:out value="${staff.salary}"/></td>
                <td><c:out value="${staff.department_id}"/></td>
                <td>
                    <a href="/loadStaffEdit?staffId=${staff.id}">Edit</a>
                    <a href="/delete?id=${staff.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>