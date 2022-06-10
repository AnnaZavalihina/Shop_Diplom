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
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Заказ</title>
</head>
<body>
<jsp:include page="header.jsp" />
<h2 style="text-align: center">ЗАКАЗ</h2>
<br>

<table><tr><td style="vertical-align: top">

<table>
    <c:forEach var="item" items="${basketItems}">

        <tr>
            <td><img src="${item.item.image}" width="200px" height="200px"></td>
            <td style="text-align: center">${item.item.name}
                <br><br><br>
                    ${item.price} руб.</td>
        </tr>
    </c:forEach>
    <br><br>
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

</td><td style="vertical-align: top; text-align: right">

<form:form action="/seedlings.by/order" modelAttribute="client">
<table style="align-self: center">
    <div style="align-content: center"><tr>
        <th> ИНФОРМАЦИЯ О КЛИЕНТЕ</th></tr>

    <tr>
    <th>

        <div style="color: red">Ваше ФИО <b>как в паспорте</b></div><br> <form:input path="name"/>
            <br><br>
            E-mail <form:input path="email"/>
            <br><br>
        Номер телефона <form:input path="telNumber" />
    </th>
    </tr>
    </div></table>
<input type="submit" value="Заказать">

</form:form>

</td></tr></table>
</body>
</html>
