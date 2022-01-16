<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>`
<!DOCTYPE html>
<html>
<body>

<h2> User info</h2>
<br>

<form:form action="saveNick" modelAttribute="nick">

    <form:hidden path="id"/>

    Name <form:input path="name"/>

    Password <form:input path="password"/>

    <br><br>
    <input type="submit" value="OK">
</form:form>

</body>
</html>