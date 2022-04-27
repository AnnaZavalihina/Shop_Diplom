<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<body>
<h2>Song info</h2>
<br>
<form:form action="saveSong" modelAttribute="song">

    <form:hidden path="id"/>

    Author <form:input path="author.name"/>
    <br><br>
    Name of the song <form:input path="name"/>
    <br><br>
    Link <form:input path="link"  placeholder="link from Youtube"/>
    <br><br>
    Lyrics <form:textarea cols="50" rows="30" path="lyrics"/>
    <br><br>
    <input type="submit" value="Ok">

</form:form>

</body>
</html>