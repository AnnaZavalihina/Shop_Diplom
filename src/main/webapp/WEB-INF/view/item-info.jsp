<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<body>
<h2>Item info</h2>
<br>
<form:form action="saveItem" modelAttribute="item">

    <form:hidden path="id"/>

    Image <form:input path="image" placeholder="Path to image"/>
    <br><br>
    Name <form:input path="name"/>
    <br><br>
    Price <form:input path="unitPrice"  placeholder="price of one item"/>
    <br><br>
    Quantity <form:input path="status"/>
    <br><br>
    Details <form:textarea cols="50" rows="30" path="details"/>
    <br><br>
    <input type="submit" value="Ok">

</form:form>

</body>
</html>