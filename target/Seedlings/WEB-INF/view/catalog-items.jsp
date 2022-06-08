
<%@ page language="java" contentType="text/html;charset=cp1251"%>
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

<ul>
<c:forEach var="type" items="${allTypes}">
    <c:url var="Type" value="/seedlings.by/type">
        <c:param name="typeId" value="${type.id}"/>
    </c:url>

    <li><a onclick="window.location.href = '${Type}'">${type.name}</a></li>
</c:forEach></ul>

<h2>������� ��������</h2>
<br>
<table>
    <tr>
        <th>��������</th>
        <th>����</th>
        <th>������</th>

    </tr>
    <c:forEach var="item" items="${allItems}">

        <tr>
            <c:url var="ItemInfo" value="/seedlings.by/item">
                <c:param name="itemId" value="${item.id}"/>
            </c:url>

            <td><a onclick="window.location.href = '${ItemInfo}'">${item.name}</a></td>
            <td>${item.unitPrice} ���.</td>
            <c:set var = "status" value = "${item.status}"/>
            <c:if test = "${status<=10 and status!=0}">
            <td>��������� <c:out value = "${salary}"/>!!!</td>
            </c:if>
            <c:if test = "${status==0}">
                <td>��� �� ������</td>
            </c:if>
        </tr>
    </c:forEach>
</table>
</body>
</html>