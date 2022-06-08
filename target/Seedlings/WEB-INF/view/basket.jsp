<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 28.04.2022
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Basket</title>
</head>
<body>
<jsp:include page="header.jsp" />

<%--<h1 style="text-align: center;">Корзина</h1>--%>
<%--<br>--%>
<%--<table>--%>
<%--    <tr>--%>
<%--        <th>Image</th>--%>
<%--        <th>Name</th>--%>
<%--        <th>Price</th>--%>
<%--        <th>Status</th>--%>
<%--        <th>Details</th>--%>

<%--        <c:url var="addButton" value="/seedlings.by">--%>
<%--            <c:param name="itemId" value="${item.id}"/>--%>
<%--        </c:url>--%>

<%--    </tr>--%>
<%--    <c:forEach var="item" items="${allItems}">--%>

<%--        <c:url var="deleteButton" value="/seedlings.by/discount">--%>
<%--            <c:param name="itemId" value="${item.id}"/>--%>
<%--        </c:url>--%>

<%--        <c:url var="Edit" value="/seedlings.by/discount">--%>
<%--            <c:param name="itemId" value="${item.id}"/>--%>
<%--        </c:url>--%>

<%--        <tr>--%>
<%--            <td>${item.image}</td>--%>
<%--            <td><a href="#">${item.name}</a></td>--%>
<%--            <td>${item.unitPrice}</td>--%>
<%--            <td>${item.status}</td>--%>
<%--            <td>${item.details}</td>--%>

<%--            <td><input type="button" value="Delete"--%>
<%--                       onclick="window.location.href = '${deleteButton}'"/>--%>
<%--            </td>--%>
<%--            <td><input type="button" value="Edit"--%>
<%--                       onclick="window.location.href = '${Edit}'"/>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--</table>--%>
<%--<br>--%>
<%--<input type="button" value="Add new Item"--%>
<%--       onclick="window.location.href = '${addButton}'"/>--%>

<%--<jsp:include page="footer.jsp" />--%>
</body>
</html>
