<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<body>

<br>
<form:form action="saveItem" modelAttribute="item">
    <h2>
        <c:if test="${item != null}">
            Edit User
        </c:if>
        <c:if test="${item == null}">
            Add New User
        </c:if>
    </h2>
    <c:if test="${item == null}">
    <form:hidden path="id"/>
    </c:if>
    <c:if test="${item != null}">
        <form: path="id" value="<c:out value="${itemId}"/>" />
    </c:if>

    Image <br><form:input path="image" placeholder="Path to image"/>
    <br><br>
    Name <br><form:input path="name" />
    <br><br>
    Price <br><form:input path="unitPrice"/>
    <br><br>
    Quantity <br><form:input path="status"/>
    <br><br>
    Details <br><form:textarea cols="50" rows="30" path="details"/>
    <br><br>
    <input type="submit" value="Ok">

</form:form>

</body>
</html>