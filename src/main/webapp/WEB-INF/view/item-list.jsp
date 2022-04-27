<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 27.04.2022
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!doctype html>
<html lang="ru">
<head>
    <title>List of users</title>
</head>
<body>
<jsp:include page="header.jsp" />
<h2>All Values</h2>
<br>
<table>
    <tr>
        <th>Image</th>
        <th>Name</th>
        <th>Price</th>
        <th>Status</th>
        <th>Details</th>

        <c:url var="addButton" value="/shop/addNewItem">
            <c:param name="itemId" value="${item.id}"/>
        </c:url>

    </tr>
    <c:forEach var="item" items="${allItems}">

        <c:url var="deleteButton" value="/shop/deleteItem">
            <c:param name="itemId" value="${item.id}"/>
        </c:url>

        <c:url var="Show" value="#">
            <c:param name="itemId" value="${item.id}"/>
        </c:url>

        <tr>
            <td>${item.image}</td>
            <td>${item.name}</td>
            <td>${item.unitPrice}</td>
            <td>${item.status}</td>
            <td>${item.details}</td>

            <td><input type="button" value="Delete"
                       onclick="window.location.href = '${deleteButton}'"/>
            </td>
            <td><input type="button" value="Show"
                       onclick="window.location.href = '${Show}'"/>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<input type="button" value="Add new Item"
       onclick="window.location.href = '${addButton}'"/>
</body>
</html>