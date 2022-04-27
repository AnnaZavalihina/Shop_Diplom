<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<body>

<h2>All Songs</h2>
<br>
<table>
<tr>
    <th>Name</th>
    <th>Author</th>
    <th>Lyrics</th>
</tr>
    <c:forEach var="song" items="${allSongs}">

        <c:url var="deleteButton" value="/deleteSong">
            <c:param name="songId" value="${song.id}"/>
        </c:url>

        <c:url var="addButton" value="/addNewSong">
            <c:param name="songId" value="${song.id}"/>
        </c:url>

        <c:url var="Show" value="/showSong">
            <c:param name="songId" value="${song.id}"/>
        </c:url>

        <tr>
            <td>${song.name}</td>
            <td>${song.author.name}</td>
            <td>${song.lyrics.substring(0,5)}...</td>

            </td>
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
<input type="button" value="Add"
       onclick="window.location.href = 'addNewSong'"/>
<br><br><br>

<%--<h2>Lyrics</h2>--%>
<br>
    <c:forEach var="line" items="${allLines}">
        <br>
            <c:forEach var="word" items="${allWords}">
                <c:if test="${word.sline.id == line.id}" >
                    <span>${word.word}</span>
                </c:if>
            </c:forEach>
<%--        <c:if test="${words.id == 6 || words.id == 4}" >--%>
<%--               <span><input  type="text" size="1"></span>--%>
<%--        </c:if>--%>
    </c:forEach>

</body>
</html>