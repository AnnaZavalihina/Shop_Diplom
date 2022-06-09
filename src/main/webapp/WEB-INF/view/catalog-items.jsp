
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!doctype html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Catalog of items</title>
</head>
<body>
<jsp:include page="header.jsp" />
<table class="main" width="80%"><tr><td style="vertical-align: top">
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
<table>
    <c:forEach var="item" items="${allItems}">

        <tr>
            <c:url var="ItemInfo" value="/seedlings.by/item">
                <c:param name="itemId" value="${item.id}"/>
            </c:url>
            <td><img src="${item.image}" width="200px" height="200px"></td>
            <td><a onclick="window.location.href = '${ItemInfo}'">${item.name}</a><br>
            ${item.unitPrice} руб.<br>
            <c:set var = "status" value = "${item.status}"/>
            <c:if test = "${status<=10 and status!=0}">
                Последние <c:out value = "${status}"/>!!!
            </c:if>
            <c:if test = "${status==0}">
                Нет на складе
            </c:if></td>
            <c:url var="Basket" value="/seedlings.by/addBasketItem">
                <c:param name="itemId" value="${item.id}"/>
            </c:url>
            <td><div style="text-align: center"><a onclick="window.location.href = '${Basket}'"><b>В корзину</b></a></div></td>

        </tr>
    </c:forEach>
</table></td></tr></table>
</body>
</html>