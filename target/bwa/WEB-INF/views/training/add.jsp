<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

        id użytkownika:
    <div>
        <f:select path="user" items="${userList}" itemValue="id" itemLabel="name"/><!--wyszukuje metody bez podawania get-->
    </div>
    <div>
        Nazwa treningu:
        <f:input path="name"/>
    </div>
    <div>
        Opis treningu:
        <f:input path="author"/><f:errors path="author" cssClass="error"/>
    </div>
    <div>
        Lista dni treningowych:
        <div>
            <%--<form:select path="wholeTraining" items="${singleTrainingDayList}" itemValue="id" itemLabel="wholeTraining"/><!--wyszukuje metody bez podawania get-->--%>
        </div>
    </div>

    
    <div>
        <input type="submit" value="Dodaj trening"/>
    </div>
</f:form>


</body>
</html>
