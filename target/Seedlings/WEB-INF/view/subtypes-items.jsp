<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 07.06.2022
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=cp1251"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!doctype html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><c:out value="${subtype.title}"/></title>
</head>
<body>
<jsp:include page="header.jsp" />

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

<c:set var = "title" value = "${}"/>
<h2><c:out value="${subtype.title}"/></h2>
<br>
<table>
    <tr>
        <th>Название</th>
        <th>Цена</th>
        <th>Статус</th>

    </tr>
    <c:forEach var="item" items="${allSubtypeItems}">

        <tr>
            <c:url var="ItemInfo" value="/seedlings.by/item">
                <c:param name="itemId" value="${item.id}"/>
            </c:url>

            <td><a onclick="window.location.href = '${ItemInfo}'">${item.name}</a></td>
            <td>${item.unitPrice} руб.</td>
            <c:set var = "status" value = "${item.status}"/>
            <c:if test = "${status<=10 and status!=0}">
                <td>Последние <c:out value = "${salary}"/>!!!</td>
            </c:if>
            <c:if test = "${status==0}">
                <td>Нет на складе</td>
            </c:if>
        </tr>
    </c:forEach>
</table>
<c:out value="${subtype.details}"/>
</body>
</html>