<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<body>

<h2> User info</h2>
<br>

<form:form action="saveUser" modelAttribute="user">

    <form:hidden path="id"/>

    first name <form:input path="firstName"/>
    <br><br>
    last name <form:input path="lastName"/>
    <br><br>
    Password <form:input path="password"/>
    <br><br>
    Email <form:input path="email"/>
    <br><br>


    Role <form:select path="role">
    <form:option value="USER" label="user"/>
    <security:authorize access="hasAuthority('developers:admin')">
        <form:option value="MANAGER" label="manager"/>
    </security:authorize>
</form:select>

    <br><br>
    <input type="submit" value="OK">
</form:form>

</body>
</html>