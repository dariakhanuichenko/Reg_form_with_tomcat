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
    <title>Create request</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>

<body>
<nav style="color:white" class="navbar fixed-top navbar-dark bg-primary">

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText"
            aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">

    </button>

    <a style="color:white" class="nav-item nav-link active" href="#">
        <spring:message code="create.request"/>
    </a>
    <a style="color:white" class="nav-item nav-link active" href="#">
        <spring:message code="my.request"/>
    </a>


    <span style="float: right">
    <a href="?lang=en"><img src="resources/United-Kingdom-flag-icon.png" height=30px/></a>
    <a href="?lang=ua"><img src="resources/Ukraine-Flag-icon.png" height=30px/></a>
    <button class="btn btn-light" type="submit" onclick="document.forms['logoutForm'].submit()">
        <spring:message code="logout"/>
    </button>
    </span>
</nav>


<form:form method="POST" modelAttribute="requestDto" class="form-signin">
    <div style="margin-top: 15px" class="container">

        <div class="form-group">
            <label for="exampleFormControlTextarea1">
                <spring:message code="new.request"/>
            </label>
            <spring:bind path="request">
                <form:textarea path="request" class="form-control" id="exampleFormControlTextarea1" rows="3"/>
            </spring:bind>
        </div>
        <spring:message code="created.request" var="message"/>
        <spring:bind path="username" >
            Your name
            <input path="username" value="${pageContext.request.userPrincipal.name}"></input>
        </spring:bind>
        <button class="btn btn-lg btn-primary btn-block" type="submit"
                onclick=window.alert(${message})>
            <spring:message code="create"/>
        </button>
    </div>
</form:form>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<%--<script type="text/javascript">--%>
<%--    function outputMessage() {--%>
<%--        alert(<spring:message code="created.request"/> );--%>
<%--    }--%>
<%--</script>--%>
</body>
</html>