
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!doctype html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>List of users</title>
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">--%>
<%--    <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>--%>
<%--    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>--%>
</head>
<body>
<%--<jsp:include page="header.jsp" />--%>
<h2>All Items</h2>
<br>
<table>
    <tr>
        <th>Image</th>
        <th>Name</th>
        <th>Price</th>
        <th>Status</th>
        <th>Details</th>

        <c:url var="addButton" value="/shop/addNewItem">
            <c:param name="itemId" value="${item.id}"/>
        </c:url>

    </tr>
    <c:forEach var="item" items="${allItems}">

        <c:url var="deleteButton" value="/shop/deleteItem">
            <c:param name="itemId" value="${item.id}"/>
        </c:url>

        <c:url var="Edit" value="/shop/editItem">
            <c:param name="itemId" value="${item.id}"/>
        </c:url>

        <tr>
            <td>${item.image}</td>
            <td><a href="#">${item.name}</a></td>
            <td>${item.unitPrice}</td>
            <td>${item.status}</td>
            <td>${item.details}</td>

            <td><input type="button" value="Delete"
                       onclick="window.location.href = '${deleteButton}'"/>
            </td>
            <td><input type="button" value="Edit"
                       onclick="window.location.href = '${Edit}'"/>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<input type="button" value="Add new Item"
       onclick="window.location.href = '${addButton}'"/>
</body>
</html>