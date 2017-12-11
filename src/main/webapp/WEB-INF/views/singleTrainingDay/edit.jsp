<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <script
            src="https://code.jquery.com/jquery-3.2.1.js"
            integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
            crossorigin="anonymous"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha3
    84-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha
    384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>

    <title>Title</title>
    <style type="text/css">
        .error {
            background-color: red;
            color: beige;
        }
         body {
             padding-top: 70px;
         }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="http://localhost:8080/bwa">Home <span class="sr-only">(current)</span></a>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Ćwiczenia</a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">
                    <a class="dropdown-item" href="http://localhost:8080/bwa/exercise/add">Dodaj</a>
                    <a class="dropdown-item" href="http://localhost:8080/bwa/exercise/all">Lista</a>
                </div>
            </li>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown02" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dzień treningowy</a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">
                    <a class="dropdown-item" href="http://localhost:8080/bwa/singleTrainingDay/add">Dodaj</a>
                    <a class="dropdown-item" href="http://localhost:8080/bwa/singleTrainingDay/all">Lista</a>
                </div>
            </li>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown03" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Trening</a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">
                    <a class="dropdown-item" href="http://localhost:8080/bwa/training/add">Dodaj</a>
                    <a class="dropdown-item" href="http://localhost:8080/bwa/training/all">Lista</a>
                </div>
            </li>
        </ul>
    </div>
</nav>
<main role="main" class="container">

    <div class="starter-template">
        <p class="lead">

        <h3>Edycja dnia treningowego</h3>
        <%--@elvariable id="exercise" type="java"--%>
        <f:form action="edit" method="post" modelAttribute="exercise"> <%--tutaj zmieniamy metodę, stosownie do widoku--%>

            <%--<div class="form-group">--%>
                <%--id użytkownika:--%>
                <%--<f:input path="userId" class="form-control"/>--%>
                <%--<f:errors path="userId" cssClass="error"/>--%>
            <%--</div>--%>

            <div class="form-group">
                Dzień treningowy:
                <f:input type="number" path="trainingDay" class="form-control"/>
                <f:errors path="trainingDay" cssClass="error"/>
            </div>

            <div class="form-group">
                Lista ćwiczeń:
                <f:input type="number" path="setNumber" class="form-control"/>
                <f:errors path="setNumber" cssClass="error"/>
            </div>

            <f:hidden path="id" />

            <div class="form-group">
                <input type="submit" value="Zapisz zmiany"/>
            </div>
        </f:form>
        </p>

    </div>
</main>

</body>
</html>
