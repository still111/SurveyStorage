
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Users</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
</head>
<body>


<table class="table">
    <tr>

        <th>#</th>
        <th>first_name</th>
        <th>last_name</th>
        <th>email</th>
        <th>role</th>
        <th>status</th>
        <th>operations</th>
    </tr>


    <c:forEach var="users" items="${allUsers}">
        <c:url var="changeButton" value="/changeStatus">
            <c:param name="user_id" value="${users.id}"/>
        </c:url>
        <c:url var="deletebutton" value="/deleteUser">
            <c:param name="user_id" value="${users.id}"/>
        </c:url>
        <tr>
            <td></td>
            <td>${users.firstName}</td>
            <td>${users.lastName}</td>
            <td>${users.email}</td>
            <td>${users.role}</td>
            <td>${users.status}</td>
            <td>
                <input type="button" value="change status"
                       onclick="window.location.href = '${changeButton}' "/>
                <input type="button" value="delete"
                       onclick="window.location.href = '${deletebutton}' "/>
            </td>
        </tr>
    </c:forEach>
</table>
<script>
    $('.table tbody tr').each(function (i) {
        var number = i;
        $(this).find('td:first').text(number + ".");
    });
</script>


<br><br>
<input type="button" value="addNew"
       onclick="window.location.href = 'userRegistration'">
<br><br>
<input type="submit" value="back"
       onclick="window.history.back()">
</body>
</html>
