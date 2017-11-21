<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        .error {
            background-color: red;
            color: beige;
        }
    </style>
</head>
<body>


<%--@elvariable id="exercise" type="java"--%>
<f:form action="edit" method="post" modelAttribute="exercise"> <%--tutaj zmieniamy metodę, stosownie do widoku--%>

    <div>
        id użytkownika:
        <f:input path="userId"/>
        <f:errors path="userId" cssClass="error"/>
    </div>
    <div>
        Dzień treningowy:
        <f:input type="number" path="trainingDay"/>
        <f:errors path="trainingDay" cssClass="error"/>
    </div>
    <div>
            <%--  tutaj dorobić  --%>
            <%--  ćwiczenia trzeba dodawać już w jakimś zestawie, a nie jako gotowe jedno --%>
        Lista ćwiczeń:
        <f:input type="number" path="setNumber"/>
        <f:errors path="setNumber" cssClass="error"/>
    </div>


    <f:hidden path="id" />
    <div>
        <input type="submit" value="Zapisz zmiany"/>
    </div>
</f:form>
</body>
</html>
