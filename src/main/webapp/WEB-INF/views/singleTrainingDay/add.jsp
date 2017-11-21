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


<%--@elvariable id="singleTrainingDay" type="java"--%>
<f:form action="add" method="post" modelAttribute="singleTrainingDay">
    <div>
        <f:errors path="*" cssClass="error"/>
    </div>

    <div>


    </div>
    <div>
        Dzień treningowy:
        <f:input type="number" path="trainingDay"/>
        <f:errors path="trainingDay" cssClass="error"/>
    </div>
    <div>

        Lista ćwiczeń:
        <f:select path="exercises" items="${exerciseList}" itemValue="id" itemLabel="name"/>
        <f:errors path="exercises" cssClass="error"/>
    </div>



    <div>
        <input type="submit" value="Dodaj dzień treningowy"/>
    </div>
</f:form>


</body>
</html>
