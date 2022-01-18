<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>List of Questions</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
</head>
<body>
<table class="table">

    <tr>
        <th>#</th>
        <th>text</th>
        <th>type</th>
        <th>var1</th>
        <th>var2</th>
        <th>var3</th>
        <th>Operations</th>
    </tr>

    <form:form action="showAllSurveys" modelAttribute="allQuest">
        <c:forEach var="quest" items="${allQuest}">


            <c:url var ="deleteButton" value="/deleteQuest">
                <c:param name="quest_id" value="${quest.id}"/>
            </c:url>

                <tr>
                <td></td>
                <td>${quest.text}</td>
                <td>${quest.type}</td>
                <td>${quest.var1}</td>
                <td>${quest.var2}</td>
                <td>${quest.var3}</td>
                    <td>

                        <input type="button" value="Delete"
                               onclick="window.location.href = '${deleteButton}' "/>
                       </td>
                </tr>

        </c:forEach>

        <input type="submit" value="back">
    </form:form>

    <script>
        $('.table tbody tr').each(function(i) {
            var number = i;
            $(this).find('td:first').text(number+".");
        });
    </script>
</table>
</body>
</html>
