<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:url var ="addNickButton" value="/addNewUser">/>
</c:url>

<table>
    <tr>

        <th>id</th>
        <th>name</th>
        <th>password</th>

    </tr>



    <c:forEach var = "nicks" items="${allNicks}">
        <c:url var ="deleteButton" value="/deleteUser">
            <c:param name="nicks_id" value="${nicks.id}"/>
        </c:url>
        <tr>

            <td>${nicks.id}</td>
            <td>${nicks.name}</td>
            <td>${nicks.password}</td>
            <td>
                <input type="button" value="Delete"
                       onclick="window.location.href = '${deleteButton}' "/>
            </td>
        </tr>
    </c:forEach>
</table>
<br><br>
<input type="button" value="Add new user"
       onclick="window.location.href = '${addNickButton}' "/>
<input type="submit" value="back"
       onclick="window.history.back()">
</body>
</html>
