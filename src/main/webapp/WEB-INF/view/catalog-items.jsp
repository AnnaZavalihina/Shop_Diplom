<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 27.04.2022
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!doctype html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>List of users</title>
</head>
<body>
<h2>All Values</h2>
<br>
<table>
    <tr>
        <th>Image</th>
        <th>Name</th>
        <th>Price</th>
        <th>Status</th>
        <th>Details</th>

    </tr>
    <c:forEach var="item" items="${allItems}">

        <tr>
            <td>${item.image}</td>
            <td><a href="#">${item.name}</a></td>
            <td>${item.unitPrice}</td>
            <td>${item.status}</td>
            <td>${item.details}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>