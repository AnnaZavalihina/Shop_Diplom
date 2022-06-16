<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 16.06.2022
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="cp1251" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Новый товар</title>
</head>
<body>
<jsp:include page="header.jsp" />
<form:form action="/seedlings.by/addItem" modelAttribute="item"
>
    <table style="align-self: center;margin: auto;width: 100%;">
        <div style="align-content: center"><tr>
            <th> ИНФОРМАЦИЯ О ТОВАРЕ</th></tr>
            <tr><br>
                <th>
                    <form:hidden path="id"/>
                    Название <form:input path="name"/>
                    <br><br>
                    Путь к картинке <form:input path="image"/>
                    <br><br>
                    Цена: <form:input pattern="[1-9]{1}[0-9]*.[0-9]{0-2}" path="unitPrice" /> руб.<br><br>
                    Детали: <form:input type="textarea"
                                        path="details" /><br><br>
                    Кол-во товара: <form:input pattern="[1-9]{1}[0-9]*" path="status" /> шт.<br><br>
                    Скидка <form:radiobutton path="discount" value="true"/>
                    Нет скидки <form:radiobutton path="discount" value="false"/>
                    <br><br>
                    Подтип <form:select path="subtype.id">
                    <c:forEach var="sub" items="${listSubtypes}">
                        <form:option value="${sub.id}">${sub.name}</form:option>
                    </c:forEach>
                </form:select>
                </th>
            </tr>
        </div></table>
    <input type="submit" value="Добавить" style="font-size: large;text-align: center;">

</form:form>
</body>
</html>
