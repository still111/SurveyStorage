<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--<c:url var ="addNickButton" value="/addNewUser">/>--%>
<%--</c:url>--%>

<table>
    <tr>

        <th>id</th>
        <th>first_name</th>
        <th>last_name</th>
        <th>email</th>
        <th>role</th>
        <th>status</th>
    </tr>


    <c:forEach var="users" items="${allUsers}">
        <%--        <c:url var ="deleteButton" value="/deleteUser">--%>
        <%--            <c:param name="nicks_id" value="${users.id}"/>--%>
        <%--        </c:url>--%>
        <tr>

            <td>${users.id}</td>
            <td>${users.firstName}</td>
            <td>${users.lastName}</td>
            <td>${users.email}</td>
            <td>${users.role}</td>
            <td>${users.status}</td>
            <td>
                    <%--                <input type="button" value="Delete"--%>
                    <%--                       onclick="window.location.href = '${deleteButton}' "/>--%>
            </td>
        </tr>
    </c:forEach>
</table>
<br><br>
<%--<input type="button" value="Add new user"--%>
<%--       onclick="window.location.href = '${addNickButton}' "/>--%>
<input type="submit" value="back"
       onclick="window.history.back()">
</body>
</html>
