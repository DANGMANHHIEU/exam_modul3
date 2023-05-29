<%--
  Created by IntelliJ IDEA.
  User: zxgak
  Date: 5/26/2023
  Time: 8:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>staffs Store Application</title>
</head>
<body>
<center>
  <h1>staffs Management</h1>
  <h2>
    <a href="/add.jsp">Add New staff</a>
    &nbsp;&nbsp;&nbsp;
    <a href="/show-list">List All staffs</a>

  </h2>
</center>
<div align="center">
  <c:if test="${staff != null}">
  <form action="#" method="post">
    </c:if>
    <c:if test="${staff == null}">
    <form action="add" method="post">
      </c:if>
      <table border="1" cellpadding="5">
        <caption>
          <h2>
            <c:if test="${staff != null}">
              Edit staff
            </c:if>
            <c:if test="${staff == null}">
              Add New staff
            </c:if>
          </h2>
        </caption>
        <c:if test="${staff != null}">
          <input type="hidden" name="id" value="<c:out value='${staff.id}' />" />
        </c:if>
        <tr>
          <th>Name: </th>
          <td>
            <input type="text" name="name" size="45"
                   value="<c:out value='${staff.name}' />"
            />
          </td>
        </tr>
        <tr>
          <th>Email: </th>
          <td>
            <input type="text" name="email" size="45"
                   value="<c:out value='${staff.email}' />"
            />
          </td>
        </tr>
        <tr>
          <th>Address: </th>
          <td>
            <input type="text" name="address" size="5"
                   value="<c:out value='${staff.address}' />"
            />
          </td>
        </tr>
        <tr>
          <th>phonenumber: </th>
          <td>
            <input type="text" name="phonenumber" size="5"
                   value="<c:out value='${staff.phonenumber}' />"
            />
          </td>
        </tr>
        <tr>
          <th>salary: </th>
          <td>
            <input type="text" name="salary" size="5"
                   value="<c:out value='${staff.salary}' />"
            />
          </td>
        </tr>
        <tr>
          <th>department: </th>
          <td>
            <input type="text" name="department" size="5"
                   value="<c:out value='${staff.department}' />"
            />
          </td>
        </tr>
        <tr>
          <td colspan="2" align="center">
            <input type="submit" value="Save" />
          </td>
        </tr>
      </table>
    </form>
</div>
</body>
</html>