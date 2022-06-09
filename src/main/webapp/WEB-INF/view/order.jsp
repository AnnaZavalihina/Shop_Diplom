<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 09.06.2022
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp" />
<h2>ЗАКАЗ</h2>
<br>
<table>
    <tr>
        <th>Название</th>
        <th>Цена</th>

    </tr>
    <c:forEach var="item" items="${basketItems}">

        <tr>
            <td>${item.item.name}</td>
            <td>${item.price} руб.</td>
        </tr>
    </c:forEach>
    <tr>
        <td><b>Общая стоимость</b></td>
        <td>${basket.price} руб.</td>
    </tr>
</table>
<c:url var="Back" value="/seedlings.by/catalog">
</c:url>
<br><br>
<div><a onclick="window.location.href = '${Back}'">Отмена</a></div>
<br>

<form:form action="/seedlings.by/order" modelAttribute="client">
<table style="align-self: center">
    <div style="align-content: center"><tr>
    <th> ИНФОРМАЦИЯ О КЛИЕНТЕ    </th>
    <th>АДРЕС ДОСТАВКИ    </th>
    </tr></div>

    <tr>
    <th>
            <form:hidden path="id" value="${hostId}"/>

            Ваше ФИО <form:input path="name"/>
            <br><br>
            E-mail <form:input path="email"/>
            <br><br>
        Номер телефона <form:input path="telNumber" />
            <br><br>
    </th>

    <th>
        Индекс <form:input path="index"/>
        <br><br>
        Город <form:input path="city"/>
        <br><br>
        Улица <form:input path="street" />
        <br><br>
        Номер дома <form:input path="building"/>
        <br>
        корпус <form:input path="housing"/>,
        квартира <form:input path="apartment"/>

    </th>
    </tr>
</table>
<input type="submit" value="Заказать">

</form:form>
</body>
</html>
