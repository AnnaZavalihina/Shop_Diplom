<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 28.04.2022
  Time: 22:28
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
    <title>Корзина</title>
</head>
<body>
<jsp:include page="header.jsp" />

<h2 style="text-align: center">КОРЗИНА</h2>
<br>
<c:if test="${basketItems.size()!=0}">
<table style="align-items: center;margin: auto;width: 80%;">
    <c:forEach var="item" items="${basketItems}">

        <tr>
            <c:url var="ItemInfo" value="/seedlings.by/item">
                <c:param name="itemId" value="${item.id}"/>
            </c:url>
            <td><img src="${item.item.image}" width="200px" height="200px"></td>
            <td><a onclick="window.location.href = '${ItemInfo}'"><div style="text-align: center">${item.item.name}</div></a> <br>

                <c:set value="${item.price}" var="itemPrice"/>
                    ${String.format('%.2f',itemPrice)} руб.</td>

            <c:url var="ReduceItem" value="/seedlings.by/reduceQuantity">
                <c:param name="itemId" value="${item.id}"/>
            </c:url>

            <c:url var="IncreaseItem" value="/seedlings.by/increaseQuantity">
            <c:param name="itemId" value="${item.id}"/>
        </c:url>


            <td><div>
                <c:if test="${item.quantity>1}">
                <a onclick="window.location.href = '${ReduceItem}'"><b><h2>-1</h2></b></a>
                </c:if>
                    ${item.quantity}

                <c:if test="${item.quantity<item.item.status}">
                <a onclick="window.location.href = '${IncreaseItem}'"><b><h2>+1</h2></b></a>
                </c:if>
            </div>
            </td>
            <c:url var="DeleteItem" value="/seedlings.by/deleteBasketItem">
                <c:param name="itemId" value="${item.id}"/>
            </c:url>
            <td><a onclick="window.location.href = '${DeleteItem}'">Удалить товар</a></td>
        </tr>
    </c:forEach>
    <tr/>
    <tr>
        <td><br><br>
            <b><h3>Общая стоимость</h3></b></td>
        <c:set value="${basket.price}" var="price"/>
        <td><b><h3>${String.format('%.2f',price)} руб.</h3></b></td>
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
    <div style="text-align: center"><h3>В корзине нет товаров</h3></div>
    <div style="font-size: medium"><a onclick="window.location.href = '${Back}'">Назад к выбору товаров</a></div>
</c:if>
</body>
</html>
