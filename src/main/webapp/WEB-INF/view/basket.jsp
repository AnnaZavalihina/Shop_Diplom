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

<h2>КОРЗИНА</h2>
<br>
<c:if test="${basketItems.size()!=0}">
<table>
    <tr>
        <th>Название</th>
        <th>Цена</th>

    </tr>
    <c:forEach var="item" items="${basketItems}">

        <tr>
            <td>${item.item.name} руб.</td>
            <td>${item.price} руб.</td>
            <c:url var="DeleteItem" value="/seedlings.by/deleteBasketItem">
                <c:param name="itemId" value="${item.id}"/>
            </c:url>
            <td><a onclick="window.location.href = '${DeleteItem}'">Удалить товар</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td><b>Общая стоимость</b></td>
        <td>${basket.price} руб.</td>
    </tr>
</table>
<c:url var="Back" value="/seedlings.by/catalog">
</c:url>
<c:url var="Order" value="/seedlings.by/makeOrder">
</c:url>
<div><a onclick="window.location.href = '${Back}'">Назад к выбору товаров</a>
<a type="button" onclick="window.location.href = '${Order}'">Оформить заказ</a></div>
</c:if>
<c:if test="${basketItems.size()==0}">
    <c:url var="Back" value="/seedlings.by/catalog">
    </c:url>
    <div style="font-size: medium;text-align: center">Вкорзине нет товаров</div>
    <div style="font-size: medium"><a onclick="window.location.href = '${Back}'">Назад к выбору товаров</a></div>
</c:if>
</body>
</html>
