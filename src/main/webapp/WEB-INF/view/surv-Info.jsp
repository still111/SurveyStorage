<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>`
<!DOCTYPE html>
<html>
<body>

<h2> Survey info</h2>
<br>

<form:form action="saveSurvey" modelAttribute="survey">

    <form:hidden path="id"/>

    Name <form:input path="name"/>
    <br><br>
    <c:if test="${survey.id == ''}">
        Start date <form:input path="startData"/>
        <br><br>
    </c:if>
    <c:if test="${survey.id != ''}">
        Start date <form:hidden path="startData"/>
    </c:if>
    Deadline <form:input path="finishData"/>
    <br><br>
    Description <form:input path="description"/>
    <br><br>
    <input type="submit" value="OK">
</form:form>

</body>
</html>