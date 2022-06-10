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
    <title>Акции Seedlings.by</title>
</head>
<body>
<jsp:include page="header.jsp" />
<h2 style="text-align: center">АКЦИИ</h2>
<br>
<table>
    <c:forEach var="item" items="${allDiscountItems}">

        <tr>
            <c:url var="ItemInfo" value="/seedlings.by/item">
                <c:param name="itemId" value="${item.id}"/>
            </c:url>
            <td><img src="${item.image}" width="200px" height="200px"></td>

            <td><a onclick="window.location.href = '${ItemInfo}'"><div style="text-align: center">${item.name}</div></a>
<br>
            <c:set var = "oldPrice" value = "${item.unitPrice/0.8}"/>
            <c:set var = "newPrice" value = "${String.format('%.2f',oldPrice)}"/>
            <div style="color: gray; text-decoration:line-through;text-align: center">${newPrice} руб.</div>
                <div style="color: red;text-align: center"> <c:out value = "${item.unitPrice}"/> руб.</div>

            <c:set var = "status" value = "${item.status}"/>
            <c:if test = "${status<=10 and status!=0}">
                <div style="text-align: center;color: darkorange">Последние <c:out value = "${status}"/>!!!</div>
            </c:if>
            <c:if test = "${status==0}">
                <div style="text-align: center">Нет на складе</div>
            </c:if>
            </td>
            <c:url var="Basket" value="/seedlings.by/addBasketItem">
                <c:param name="item" value="${item.id}"/>
            </c:url>
            <td><div style="text-align: center"><a onclick="window.location.href = '${Basket}'"><b>Добавить в корзину</b></a></div></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>