<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Информация о товаре</title>
</head>
<body>
<jsp:include page="header.jsp" />
<h2 style="text-align: center">${item.name}</h2>
<table><tr><td>
    <p><img src="${item.image}" alt="${item.name}" width="200px" height="200px" class="leftimg"></p></td>
    <td>
    <c:out value="${item.details}"/><c:out value="${item.unitPrice}"/>
<c:url var="Basket" value="/seedlings.by/addBasketItem">
    <c:param name="itemId" value="${item.id}"/>
</c:url>

<c:url var="Back" value="/seedlings.by/type">
    <c:param name="typeId" value="${item.subtype.type.id}"/>
</c:url>
    </td></tr></table>
<div style="text-align: right"><h3><a onclick="window.location.href = '${Basket}'">В корзину</a></h3></div>
<a onclick="window.location.href = '${Back}'">Назад к выбору товара</a>
</body>
</html>