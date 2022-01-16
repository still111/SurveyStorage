<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>`
<!DOCTYPE html>
<html>
<body>

<h2> Quest info</h2>
<br>




<form:form action="saveQuest" modelAttribute="question" >


    <form:hidden path="id"/>


    Text <form:input path="text"/>
    <br><br>

    Variant 1 <form:input path="var1"/>
    <br><br>
    Variant 2 <form:input path="var2"/>
    <br><br>
    Variant 3 <form:input path="var3"/>
    <br><br>
   Type
    <form:select path="type">
        <form:option value="oneAns" label="Chose 1 answer" />
        <form:option value="manyAns" label="Chose many answer" />
        <form:option value="writeAns" label="Write answer" />
    </form:select>
    <br><br>
    <input type="submit" value="OK">

</form:form>


</body>
</html>