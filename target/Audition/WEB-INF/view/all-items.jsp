<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 26.04.2022
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<body>

<h2>All Values</h2>
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

        <c:url var="Show" value="#">
            <c:param name="itemId" value="${item.id}"/>
        </c:url>

        <tr>
            <td>${item.image}</td>
            <td>${item.name}</td>
            <td>${item.unitPrice}</td>
            <td>${item.status}</td>
            <td>${item.details}</td>

            <td><input type="button" value="Delete"
                       onclick="window.location.href = '${deleteButton}'"/>
            </td>
            <td><input type="button" value="Show"
                       onclick="window.location.href = '${Show}'"/>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<input type="button" value="Add new Item"
       onclick="window.location.href = '${addButton}'"/>
<br><br><br>

<%--&lt;%&ndash;<h2>Lyrics</h2>&ndash;%&gt;--%>
<%--<br>--%>
<%--<c:forEach var="line" items="${allLines}">--%>
<%--    <br>--%>
<%--    <c:forEach var="word" items="${allWords}">--%>
<%--        <c:if test="${word.sline.id == line.id}" >--%>
<%--            <span>${word.word}</span>--%>
<%--        </c:if>--%>
<%--    </c:forEach>--%>
<%--    &lt;%&ndash;        <c:if test="${words.id == 6 || words.id == 4}" >&ndash;%&gt;--%>
<%--    &lt;%&ndash;               <span><input  type="text" size="1"></span>&ndash;%&gt;--%>
<%--    &lt;%&ndash;        </c:if>&ndash;%&gt;--%>
<%--</c:forEach>--%>

</body>
</html>