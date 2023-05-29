<%--
  Created by IntelliJ IDEA.
  User: zxgak
  Date: 5/26/2023
  Time: 9:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Books Store Application</title>
</head>
<body>
<center>
  <h1>Books Management</h1>
  <h2>
    <a href="/add">Add New Book</a>
    &nbsp;&nbsp;&nbsp;
    <a href="/show-list">List All Books</a>

  </h2>
</center>
<div align="center">
  <c:if test="${staff != null}">
  <form action="update" method="post">
    </c:if>
    <c:if test="${staff == null}">
    <form action="update" method="post">
      </c:if>
      <table border="1" cellpadding="5">
        <caption>
          <h2>
            <c:if test="${staff != null}">
              Edit Book
            </c:if>
            <c:if test="${staff == null}">
              Add New Book
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
          <th>phoneNumber: </th>
          <td>
            <input type="text" name="phoneNumber" size="5"
                   value="<c:out value='${staff.phoneNumber}' />"
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
          <th>Department: </th>
          <td>
            <input type="text" name="department" size="5"
                   value="<c:out value='${staff.department_id}' />"
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