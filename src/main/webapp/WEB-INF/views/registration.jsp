<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Create an account</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

</head>

<body>

<nav class="navbar fixed-top navbar-inverse bg-primary">
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
            data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false"
            aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <span class="locale" style="float: right">
    <a href="?lang=en"><img src="resources/United-Kingdom-flag-icon.png" height=30px/></a>
    <a href="?lang=ua"><img src="resources/Ukraine-Flag-icon.png" height=30px/></a>
    </span>
</nav>

<div style="margin-top: 15px" class="container">

    <form:form method="POST" modelAttribute="userForm" class="form-signin">
        <h2 class="form-signin-heading">
            <spring:message code="create.account"/>
        </h2>
        <spring:bind path="username">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <spring:message code="username" var="placeholder"/>
                <form:input type="text" path="username" class="form-control" placeholder='${placeholder}'
                            autofocus="true"/>
                <form:errors path="username"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <spring:message code="password" var="placeholder"/>
                <form:input type="password" path="password" class="form-control" placeholder='${placeholder}'
                />
                <form:errors path="password"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="confirmPassword">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <spring:message code="confirm.password" var="placeholder"/>
                <form:input type="password" path="confirmPassword" class="form-control"
                            placeholder='${placeholder}'/>
            </div>
        </spring:bind>

        <spring:bind path="roles">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <label>
                select your role
            </label>
            <form:select path="roles" class="selectpicker">
                <form:option value="ROLE_USER">
                    <spring:message code="role.user"/>
                </form:option >
                <form:option  value="ROLE_MASTER">
                    <spring:message code="role.master"/>
                </form:option >
                <form:option  value="ROLE_MANAGER">
                    <spring:message code="role.manager"/>
                </form:option >
            </form:select>
        </div>
    </spring:bind>
        <button class="btn btn-lg btn-primary btn-block" type="submit">
            <spring:message code="submit"/>
        </button>
    </form:form>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>