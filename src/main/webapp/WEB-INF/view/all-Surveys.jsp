<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
        <title>List of surveys</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
</head>
<body>

<c:url var ="addSurvButton" value="/addNewSurvey">/>
</c:url>

<table class="table">

        <tr>
                <th>#</th>
                <th>Name</th>
                <th>Start date</th>
                <th>Finish date</th>
                <th>Description</th>
                <th>Operations</th>

        </tr>

        <c:forEach var="surv" items="${allSurv}">

                <c:url var ="questsButton" value="/showDetQuests">
                        <c:param name="survey_id" value="${surv.id}"/>
                </c:url>

                <c:url var ="questsAddButton" value="/addQuest">
                        <c:param name="survey_id" value="${surv.id}"/>
                </c:url>

                <c:url var ="updateButton" value="/updateSurvey">
                        <c:param name="survey_id" value="${surv.id}"/>
                </c:url>
                <c:url var ="deleteButton" value="/deleteSurvey">
                        <c:param name="survey_id" value="${surv.id}"/>
                </c:url>

                <c:url var ="selectQuestsButton" value="/selectDetQuests">
                        <c:param name="survey_id" value="${surv.id}"/>
                </c:url>

                        <td></td>
                        <td>${surv.name}</td>
                        <td>${surv.startData}</td>
                        <td>${surv.finishData}</td>
                        <td>${surv.description}</td>
                       <td>
                                <input type="button" value="select"
                                      onclick="window.location.href = '${selectQuestsButton}' "/>
                               <security:authorize access="hasAuthority('developers:write')">
                               <input type="button" value="Show quests"
                                      onclick="window.location.href = '${questsButton}' "/>
                               <input type="button" value="Update"
                                      onclick="window.location.href = '${updateButton}' "/>
                               <input type="button" value="Delete"
                                      onclick="window.location.href = '${deleteButton}' "/>
                               <input type="button" value="addQuest"
                                      onclick="window.location.href = '${questsAddButton}' "/> </td>
                               </security:authorize>
                </tr>



        </c:forEach>



</table>
<security:authorize access="hasAuthority('developers:write')">
<input type="button" value="Add new survey"
       onclick="window.location.href = '${addSurvButton}' "/>
</security:authorize>
<br><br>

<input type="submit" value="back"
       onclick="window.history.back()">
<br><br><br>
<security:authorize access="hasAuthority('developers:write')">
 <a href="showAllQuestions"> List of all questions </a>
</security:authorize>
<script>
        $('.table tbody tr').each(function(i) {
                var number = i;
                $(this).find('td:first').text(number+".");
        });
</script>



<br><br>
<a href="<c:url value="/logout" />">Logout</a>

</body>
</html>
