<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 06.06.2022
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Вопрос-ответ</title>
</head>
<body>
<jsp:include page="header.jsp" />

<h1 class="title title_center">ВОПРОС-ОТВЕТ</h1>
<div>Задать вопрос</div>

<form:form action="/seedlings.by/your-question" modelAttribute="question">
    <form:hidden path="id"/>
    Ваше ФИО <form:input path="username"/><br>
    Вопрос <form:textarea cols="50" rows="5" path="text"/><br>
    <input type="submit" value="Ok">
</form:form>

<table>
    <tr>
        <th>ФИО</th>
        <th>Вопрос</th>
        <th>Дата</th>

    </tr>
    <c:forEach var="quest" items="${allQuestion}">
        <tr>
            <td>${quest.username}</td>
            <td>${quest.text}</td>
            <c:set var="dateQuest" value="${formatForDateNow.format(quest.date)}"/>
            <td>${dateQuest}</td>
        </tr>

    </c:forEach>
</table>
</body>
</html>
