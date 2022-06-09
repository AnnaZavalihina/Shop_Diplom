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
<h2>${item.name}</h2>
<p><img src="" alt="${item.name}" width="132" height="174" class="leftimg">
    <c:out value="${item.details}"/><c:out value="${item.unitPrice}"/></p>
<c:url var="Basket" value="/seedlings.by/addBasketItem">
    <c:param name="itemId" value="${item.id}"/>
</c:url>

<c:url var="Back" value="/seedlings.by/type">
    <c:param name="typeId" value="${item.subtype.type.id}"/>
</c:url>

<div style="text-align: center"><a onclick="window.location.href = '${Basket}'">В корзину</a></div>
<a onclick="window.location.href = '${Back}'">Назад к выбору товара</a>
</body>
</html>