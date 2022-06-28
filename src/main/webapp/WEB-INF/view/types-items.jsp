<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 07.06.2022
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!doctype html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><c:out value="${type.name}"/></title>
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

        <li>
            <a onclick="window.location.href = '${Type}'">${type.name}</a>
        </li>

        <c:if test = "${typeId==type.id}">
            <ul>
                <c:forEach var="subtype" items="${allSubtypes}">
                <c:url var="Subtype" value="/seedlings.by/subtype">
                    <c:param name="subtypeId" value="${subtype.id}"/>
                    <c:param name="typeId" value="${typeId}"/>
                </c:url>
                    <li>
                        <a onclick="window.location.href = '${Subtype}'">${subtype.name}</a>
                    </li>
                </c:forEach>
            </ul>
        </c:if>

    </c:forEach>
</ul>
</td>
<td>

<h2 style="text-align: center"><c:out value="${type.name}"/></h2>

<table style="align-self: center;margin: auto;width: 100%;"><tr>

    <c:forEach var="item" items="${allTypeItems}">

        <td>
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
</table>
    <div style="text-align: center"><c:out value="${type.details}"/></div>
</td></tr></table>
</body>
</html>