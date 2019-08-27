<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%--<form:form method="get">--%>
<%--<c:set var="request_title" value="${requestTitle}"></c:set></form:form>--%>
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
<form action="${contextPath}/login?logout">
<nav style="color:white" class="navbar fixed-top navbar-dark bg-primary">

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText"
            aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">

    </button>

    <a style="color:white" class="nav-item nav-link active" href="userCreateRequest">
        <spring:message code="check.new.request"/>
    </a>


    <span style="float: right">
    <a href="?lang=en"><img src="resources/United-Kingdom-flag-icon.png" height=30px/></a>
    <a href="?lang=ua"><img src="resources/Ukraine-Flag-icon.png" height=30px/></a>
    <button class="btn btn-light" type="submit" onclick="document.forms['logoutForm'].submit()">
        <spring:message code="logout"/>
    </button>
    </span>
</nav>
</form>
<div style="margin-top: 15px" class="container">
    <h2>
        <spring:message code="new.requests"/>
    </h2>

    <form:form method="post"  modelAttribute="requests">
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <table class="table table-hover">
                <thead>
                <tr>

                    <th><spring:message code="request"/></th>
                    <th><spring:message code="price"/></th>
                    <th><spring:message code="status"/></th>
                    <th><spring:message code="master"/></th>
                    <th><spring:message code="reason"/></th>
                    <th> actions</th>
                </tr>
                </thead>
                <c:forEach items="${requestTitle}" var="r">
                    <tbody>
                    <tr>
                        <td ><c:out value="${r}"/></td>
                        <td>
                            <spring:message code="price" var="price"/>
                            <form:input path="price" type="text" class="form-control" placeholder='${price}'
                                        autofocus="true"/>
                        </td>
                        <td>
                            <form:select path="status" class="selectpicker">
                                <form:option value="accepted">
                                    <spring:message code="accepted"/>
                                </form:option>

                                <form:option value="rejected">
                                    <spring:message code="rejected"/>
                                </form:option>
                            </form:select></td>
                        <td>
                            <form:select path="master" class="selectpicker">
                                <c:forEach items="${masters}" var="m">
                                    <option value="${m}">
                                            ${m}
                                    </option>
                                </c:forEach>
                            </form:select>
                        </td>
                        <td>
                            <spring:message code="reason" var="reason"/>
                            <form:input path="reason" type="text"   class="form-control" placeholder='${reason}'
                                        autofocus="true"/>
                        </td>
                        <td>
                            <button class="btn btn-lg btn-primary btn-block" type="submit" onclick=""> save</button>
                        </td>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>
        </c:if>
        <c:if test="${pageContext.request.userPrincipal.name == null}">
            <h3><spring:message code="empty.name"/></h3>
        </c:if>
    </form:form>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>