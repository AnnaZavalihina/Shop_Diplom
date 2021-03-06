<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 09.06.2022
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Заказ</title>
</head>
<body>
<jsp:include page="header.jsp" />
<h2 style="text-align: center">ЗАКАЗ</h2>
<br>

<table style="margin: auto;width: 100%;border: black;"><tr><td style="vertical-align: top;width: 50%;">

<table style="margin: auto;width: 100%;border: black;">
    <h3 style="text-align: center">Товары</h3>
    <c:forEach var="item" items="${basketItems}">

        <tr>
            <td><img src="${item.item.image}" width="200px" height="200px"></td>
            <td style="text-align: center">${item.item.name}
                <br><br>
                <c:set value="${item.price}" var="price"/>
                    ${String.format('%.2f',price)} руб.</td>
        </tr>
    </c:forEach>
    <tr>
        <td><b><h3>Общая стоимость</h3></b></td>
        <c:set value="${basket.price}" var="basketPrice"/>
        <td><b><h3>${String.format('%.2f',basketPrice)} руб.</h3></b></td>
    </tr>
</table>
<c:url var="Back" value="/seedlings.by/catalog">
</c:url>
<br><br>
<a onclick="window.location.href = '${Back}'">Отмена</a>
<br>

</td><td style="vertical-align: top; margin: auto;">

<form:form action="/seedlings.by/order" modelAttribute="client">
<table style="align-self: center;margin: auto;width: 100%;">
    <div style="align-content: center"><tr>
        <th> ИНФОРМАЦИЯ О КЛИЕНТЕ</th></tr>

    <tr><br>
    <th>

        Ваше ФИО <b>(в латинской транскрипции)</b><br> <form:input pattern="^[A-Z]{1}[a-z]+ [A-Z]{1}[a-z]+[ ]*[A-Za-z]*" path="name"/>
            <br><br>
            E-mail <form:input type="email" path="email"/>
            <br><br>
        Номер телефона в виде XX XXXX XXX<br>
        <form:input type="tel" minlength="9" pattern="[1-9][0-9\s]{8,}" path="telNumber" /><br>
    </th>
    </tr>
    </div></table>
<input type="submit" value="Заказать" style="font-size: large;text-align: center;">

</form:form>

</td></tr></table>

</body>
</html>
