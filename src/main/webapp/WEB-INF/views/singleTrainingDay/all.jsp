<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<html>
<head>
    <title>exercise list</title>
</head>
<body>
    <h2>Lista ćwiczeń</h2>

    <table>
        <tr>
            <th>Id</th>
            <th>Id użytkownika</th>
            <th>Dzień treningowy</th>
            <th>Lista ćwiczeń</th>

        </tr>
        <%-- ${model} --%>
        <c:forEach items="${singleTrainingDays}" var="singleTrainingDay">
            <tr>
                <%--<td>${singleTrainingDay.id}</td>--%>

                <%--<td>${singleTrainingDay.trainingDay}</td>--%>
                <%--<td>${singleTrainingDay.exercises.toString}</td>--%>

                <%--<td><a href="edit?id=${singleTrainingDay.id}">Edytuj</a> </td>--%>
                <%--<td><a href="delete?id=${singleTrainingDay.id}">Usuń</a> </td>--%>
            </tr>
        </c:forEach>

<%--@elvariable id="singleTrainingDay" type="java"--%>
        <%--<f:form action="add" method="post" modelAttribute="singleTrainingDay">--%>
        <%--<br>--%>
            <%--<a href="add?id=${singleTrainingDay.id}">Dodaj ćwiczenie</a>--%>
        <%--<br>--%>

        <%--<f:hidden path="id" />--%>

    </table>
    <br>
    <a href="add">dodaj nowy dzień treningowy</a>

    <br>
    <a href="">index</a>

    <br>

</body>
</html>