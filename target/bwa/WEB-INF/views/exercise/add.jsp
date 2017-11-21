<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<f:form action="add" method="post" modelAttribute="exercise">
    <div>
        <%--<f:errors path="*" cssClass="error"/>--%>
    </div>

    <div>
        Nazwa ćwiczenia:
        <f:input path="name"/>
        <f:errors path="name" cssClass="error"/>
    </div>
    <div>
        Opis wykonania:
        <f:textarea cols="30" rows="4" path="description"/>
        <f:errors path="description" cssClass="error"/>

    </div>
    <div>
        Liczba serii:
        <f:input type="number" path="setNumber"/>
        <f:errors path="setNumber" cssClass="error"/>
    </div>
    <div>
        Sugerowane powtórzenia:
        <f:input type="number" path="rep"/>
        <f:errors path="rep" cssClass="error"/>
    </div>

    <div>
        <input type="submit" value="Dodaj ćwiczenie"/>
    </div>
</f:form>


</body>
</html>
