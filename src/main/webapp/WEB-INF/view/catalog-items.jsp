
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!doctype html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Каталог Seedlings.by</title>
</head>
<body>
<jsp:include page="header.jsp" />
<table style="width: 100%;align-self: center;margin: auto;"><tr>
    <td style="vertical-align: top;width: 25%;">
<ul>
<c:forEach var="type" items="${allTypes}">
    <c:url var="Type" value="/seedlings.by/type">
        <c:param name="typeId" value="${type.id}"/>
    </c:url>

    <li><a onclick="window.location.href = '${Type}'">${type.name}</a></li>
</c:forEach></ul></td>
<td>
<h2 style="text-align: center">КАТАЛОГ РАСТЕНИЙ</h2>
<br>

<table style="width: 100%;align-self: center;margin: auto;">
    <c:forEach var="item" items="${allItems}">

        <tr>
            <c:url var="ItemInfo" value="/seedlings.by/item">
                <c:param name="itemId" value="${item.id}"/>
            </c:url>
            <td><img src="${item.image}" width="200px" height="200px" alt="${item.name}"></td>
            <td><a onclick="window.location.href = '${ItemInfo}'"><div style="text-align: center">${item.name}</div></a><br>
                <c:if test="${item.discount==false}">
                <div style="text-align: center">${item.unitPrice} руб.</div>
                </c:if>

                <c:if test="${item.discount==true}">
                    <c:set var = "bigPrice" value = "${item.unitPrice/0.8}"/>
                    <c:set var = "oldPrice" value = "${String.format('%.2f',bigPrice)}"/>

            <div style="color: gray; text-decoration:line-through;text-align: center">${oldPrice} руб.</div>
                <div style="color: red;text-align: center"> <c:out value = "${item.unitPrice}"/> руб.</div>
                </c:if>

                <br>
            <c:set var = "status" value = "${item.status}"/>
            <c:if test = "${status<=10 and status!=0}">
                <div style="text-align: center;color: darkorange">Последние <c:out value = "${status}"/>!!!</div>
            </c:if>
            <c:if test = "${status==0}">
                <div style="text-align: center">Нет на складе</div>
            </c:if></td>
            <c:url var="Basket" value="/seedlings.by/addBasketItem">
                <c:param name="itemId" value="${item.id}"/>
            </c:url>
            <td><div style="text-align: center"><a onclick="window.location.href = '${Basket}'"><b>Добавить в корзину</b></a>

            </div></td>

        </tr>
    </c:forEach>
</table></td></tr></table>
</body>
</html>