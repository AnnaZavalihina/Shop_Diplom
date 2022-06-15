<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Информация о <c:out value="${item.name}"/></title>
</head>
<body>
<jsp:include page="header.jsp" />
<h2 style="text-align: center">${item.name}</h2>
<table style="margin: auto; width: 90%;"><tr><td>
    <img src="${item.image}" alt="${item.name}" width="200px" height="200px" class="leftimg"></td>
    <td>
    <c:out value="${item.details}"/><br><br>
<div style="text-align: center">
    <b>Параметры посадочного материала</b><br>
        Срок отправки: с 10 марта<br>
        Количество: 1 шт.<br>
        Цена: <c:out value="${item.unitPrice}"/> руб.<br>
</div>

<c:url var="Basket" value="/seedlings.by/addBasketItem">
    <c:param name="itemId" value="${item.id}"/>
</c:url>

<c:url var="Back" value="/seedlings.by/type">
    <c:param name="typeId" value="${item.subtype.type.id}"/>
</c:url>
    </td></tr></table>
<div style="text-align: right"><h3><a onclick="window.location.href = '${Basket}'">Добавить в корзину</a></h3></div>
<a onclick="window.location.href = '${Back}'">Назад к выбору товара</a>
</body>
</html>