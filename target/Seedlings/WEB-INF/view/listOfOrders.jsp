<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 16.06.2022
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Заказы</title>
</head>
<body>
<jsp:include page="header.jsp" />

<h2 style="text-align: center">СПИСОК ЗАКАЗОВ</h2>
<br>
<c:url var="List" value="/seedlings.by/listOrders"/>

<c:url var="False" value="/seedlings.by/listMadeOrders">
    <c:param name="made" value="false"/>
</c:url>

<c:url var="True" value="/seedlings.by/listMadeOrders">
    <c:param name="made" value="true"/>
</c:url>

<table style="margin: auto;width: 50%;">
    <tr>
        <td>
            <a onclick="window.location.href = '${List}'">Все</a>
        </td>
        <td>
            <a onclick="window.location.href = '${False}'">Незавершенные</a>
        </td>
        <td>
            <a onclick="window.location.href = '${True}'">Завершенные</a>
        </td>
    </tr>
</table>
<br>
<table style="width: 85%;align-self: center;margin: auto;">
    <c:forEach var="order" items="${allOrders}">
    <tr>
        <c:url var="Switch" value="/seedlings.by/switchStatus">
            <c:param name="orderId" value="${order.id}"/>
        </c:url>

        <td>
            <c:set var="date" value="${formatForDateNow.format(order.date)}"/>
            ${date}</td>
        <td>${order.price} руб.</td>
            <c:set var="orderItems" value="${order.orderItems}"/>
        <td>
            <c:forEach var="item" items="${orderItems}">
                ${item.item.name}, в кол-ве: ${item.quantity} шт.<br>
            </c:forEach>
        </td>
        <c:if test="${order.status.equals('false')}">
            <td><a onclick="window.location.href = '${Switch}'">Order is made</a></td></c:if>
        </c:forEach>
        <br>
    </tr>
</table>

</body>
</html>
