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

<h2 style="text-align: center">КОРЗИНА</h2>
<br>
<c:if test="${basketItems.size()!=0}">
<table style="align-items: center">
    <c:forEach var="item" items="${basketItems}">

        <tr>
            <td><img src="${item.item.image}" width="200px" height="200px"></td>
            <td>${item.item.name} <br>
                    ${item.price} руб.</td>
            <td>   ${item.quantity}   </td>
            <c:url var="DeleteItem" value="/seedlings.by/deleteBasketItem">
                <c:param name="itemId" value="${item.id}"/>
            </c:url>
            <td><a onclick="window.location.href = '${DeleteItem}'">Удалить товар</a></td>
        </tr>
    </c:forEach><br><br><br>
    <tr>
        <td><b><h3>Общая стоимость</h3></b></td>
        <td><b><h3>${basket.price} руб.</h3></b></td>
    </tr>
</table>
<c:url var="Back" value="/seedlings.by/catalog">
</c:url>
<c:url var="Order" value="/seedlings.by/makeOrder">
</c:url>
    <br><br><br>
<div><a onclick="window.location.href = '${Back}'">Назад к выбору товаров</a>
    <a type="button" onclick="window.location.href = '${Order}'"><div style="text-align: right"><h2><b>Оформить заказ</b></h2></div></a></div>
</c:if>
<c:if test="${basketItems.size()==0}">
    <c:url var="Back" value="/seedlings.by/catalog">
    </c:url>
    <div style="text-align: center"><h3>Вкорзине нет товаров</h3></div>
    <div style="font-size: medium"><a onclick="window.location.href = '${Back}'">Назад к выбору товаров</a></div>
</c:if>
</body>
</html>
