<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Main Page</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<span style="float: right">
    <a href="?lang=en">en</a>
    <a href="?lang=ua">ua</a>
    </span>
<div class="container">

    <h1>
        <spring:message code="main.text"/>
    </h1>

    <form action="${contextPath}/login" style="float: left; padding-left: 10%;">
        <button class="btn btn-lg btn-primary btn-block" type="submit">
            <spring:message code="login"/>
        </button>
    </form>

    <form action="${contextPath}/registration" style="float: right; padding-right: 10%;">
        <button class="btn btn-lg btn-primary btn-block" type="submit">
            <spring:message code="registration"/>
        </button>
    </form>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>