<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BWapp - login</title>
    <link rel="stylesheet" type="text/css" href="login.css">
</head>
<body>

    <div class="login-wrap">
        <div class="login-html">

            <%--@elvariable id="person" type="java"--%>
            <f:form action="add" method="post" modelAttribute="person">
                <f:input id="tab-1" type="radio" name="tab" class="sign-in" checked path=""/><label for="tab-1" class="tab">Sign In</label>
            <f:input id="tab-2" type="radio" name="tab" class="sign-up" path="" /><label for="tab-2" class="tab">Sign Up</label>
            <div class="login-form">
                <div class="sign-in-htm">
                    <div class="group">
                        <label for="user" class="label">Username</label>
                        <f:input id="user" type="text" class="input" path="" />
                    </div>
                    <div class="group">
                        <label for="pass" class="label">Password</label>
                        <f:input id="pass" type="password" class="input" data-type="password" path="" />
                    </div>
                    <div class="group">
                        <label for="check"><span class="icon"></span> Keep me Signed in</label>
                        <f:input id="check" type="checkbox" class="check" checked path="" />
                    </div>
                    <div class="group">
                        <f:input type="submit" class="button" value="Sign In" path="" />
                    </div>
                    <div class="hr"></div>
                    <div class="foot-lnk">
                        <a href="#forgot">Forgot Password?</a>
                    </div>
                </div>
                <div class="sign-up-htm">
                    <div class="group">
                        <f:input id="user" type="text" class="input" path="" />
                        <label for="user" class="label">Username</label>
                    </div>
                    <div class="group">
                        <f:input id="pass" type="password" class="input" data-type="password" path="" />
                        <label for="pass" class="label">Password</label>
                    </div>
                    <div class="group">
                        <label for="pass" class="label">Repeat Password</label>
                        <f:input id="pass" type="password" class="input" data-type="password" path="" />
                    </div>
                    <div class="group">
                        <label for="pass" class="label">Email Address</label>
                        <f:input id="pass" type="text" class="input" path="" />
                    </div>
                    <div class="group">
                        <input type="submit" class="button" value="Zarejestruj się">
                    </div>
                    <div class="hr"></div>
                    <div class="foot-lnk">
                        <label for="tab-1">Already Member?</label>
                    </div>
                </div>
            </div>
            </f:form>
        </div>
    </div>
</body>
</html>
