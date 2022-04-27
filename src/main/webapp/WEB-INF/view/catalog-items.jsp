
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!doctype html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>List of users</title>
</head>
<body>
<h2>All Items</h2>
<br>
<table>
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Status</th>

    </tr>
    <c:forEach var="item" items="${allItems}">

        <tr>
            <td><a href="#">${item.name}</a></td>
            <td>${item.unitPrice}</td>
            <td>${item.status}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>