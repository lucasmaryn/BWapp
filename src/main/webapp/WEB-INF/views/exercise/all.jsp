<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<html>
<head>
    <title>exercise list</title>
</head>
<body>
<h2>Lista ćwiczeń</h2>
<%--spring01hibernate--%>
<table>
    <tr>
        <th>Id</th>
        <th>Nazwa ćwiczenia</th>
        <th>Opis wykonania</th>
        <th>Liczba serii</th>
        <th>Sugerowane powtórzenia</th>

    </tr>
    <%-- ${model} --%>
    <c:forEach items="${exercises}" var="exercise">
        <tr>
            <td>${exercise.id}</td>
            <td>${exercise.name}</td>
            <td>${exercise.description}</td>
            <td>${exercise.setNumber}</td>
            <td>${exercise.rep}</td>

            <td><a href="edit?id=${exercise.id}">Edytuj</a> </td>
            <td><a href="delete?id=${exercise.id}">Usuń</a> </td>
        </tr>
    </c:forEach>
</table>
<a href="add">dodaj nowe ćwiczenie</a>
<a href="..">index</a>
</body>
</html>
