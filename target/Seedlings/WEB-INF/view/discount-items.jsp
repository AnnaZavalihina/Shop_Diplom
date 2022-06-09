<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 07.06.2022
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!doctype html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Catalog of discount items</title>
</head>
<body>
<jsp:include page="header.jsp" />
<h2>Скидка</h2>
<br>
<table>
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Status</th>

    </tr>
    <c:forEach var="item" items="${allDiscountItems}">

        <tr>
            <c:url var="ItemInfo" value="/seedlings.by/item">
                <c:param name="itemId" value="${item.id}"/>
            </c:url>

            <td><a onclick="window.location.href = '${ItemInfo}'">${item.name}</a></td>
            <c:set var = "oldPrice" value = "${item.unitPrice/0.8}"/>
            <c:set var = "newPrice" value = "${String.format('%.2f',oldPrice)}"/>
            <td><div style="color: gray; text-decoration:line-through">${newPrice}</div>
                <div style="color: red; text-decoration:blink"> <c:out value = "${item.unitPrice}"/> </div></td>
            <c:set var = "status" value = "${item.status}"/>
            <c:if test = "${status<=10 and status!=0}">
                <td>Последние <c:out value = "${status}"/>!!!</td>
            </c:if>
            <c:if test = "${status==0}">
                <td>Нет на складе</td>
            </c:if>
            <c:url var="Basket" value="/seedlings.by/addBasketItem">
                <c:param name="item" value="${item.id}"/>
            </c:url>
            <td><div style="text-align: center"><a onclick="window.location.href = '${Basket}'">В корзину</a></div></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>