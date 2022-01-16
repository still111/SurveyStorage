<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h2> Welcome to surveys service </h2>
<br><br>
<security:authorize access="hasAuthority('developers:admin')">
    <input type="button" value="List of users"
           onclick="window.location.href = 'showNicks'">
    Only for Admin
</security:authorize>

<br><br>
<form:form action="showAllSurveys">
    <input type="submit" value="List of surveys">
</form:form>

<br><br>
<a href="<c:url value="/logout" />">Logout</a>

</body>
</html>
