<%--
  Created by IntelliJ IDEA.
  User: Main
  Date: 21.04.2015
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%--@elvariable id="shop" type="nom.lesha.firsWeb.model.Shop"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>handle item</title>
</head>
<body>

<%--<c:set var="shop" value="${requestScope.shop}"/>--%>
<c:if test="${(param.action == 'to.employee.add') || (requestScope.action == 'to.employee.add') }">
    <h2>Add employee to <u>${param.shopName}</u> shop:</h2>
</c:if>
<c:if test="${(param.action == 'to.employee.edit') || (requestScope.action == 'to.employee.edit')}">
    <h2>Edit employees params from <u>${param.shopName}</u> shop:</h2>
</c:if>
<c:if test="${(param.action == 'to.employee.delete') || (requestScope.action == 'to.employee.delete')}">
    <h2>Delete employees params from <u>${param.shopName}</u> shop:</h2>
</c:if>

<c:if test="${requestScope.get('employeeValidationReport') != null}">
    <h2><font color="#ff7f50">Employee validation error...</font></h2><br>
    <table cellspacing="7">
        <c:forEach var="entry" items="${employeeValidationReport}">

            <tr>
                <th><c:out value="${entry.key}"/></th>
                <td><c:out value="${entry.value}"/></td>
            </tr>

        </c:forEach>
    </table>
</c:if>

<form id="data" method="post">
    <input type="hidden" name="shopId" value="${param.shopId}">
    <input type="hidden" name="shopName" value="${param.shopName}">

    <%--Show id field if edit or delete action--%>
    <table border="1" cellpadding="2">
        <c:if test="${(param.action == 'to.employee.edit') || (param.action == 'to.employee.delete') ||
                        (requestScope.action == 'to.employee.edit') || (requestScope.action == 'to.employee.delete')}">
            <tr>
                <th bgcolor="#ffe4c4">id</th>
                <th bgcolor="#ffe4c4">
                    <b>${employee.id}</b>
                    <input type="hidden" name="employeeId" value="${employee.id}">
                </th>
            </tr>
        </c:if>
        <tr>
            <th bgcolor="#ffe4c4">Name</th>
            <td><input type="text" name="employeeName" value="${employee.name}"></td>
        </tr>
        <c:if test="${param.shopId == null}">
            <tr>
                <th bgcolor="#ffe4c4">Shop id</th>
                <td><input type="text" name="shopId"></td>
            </tr>
        </c:if>
    </table>
</form>

<table>
    <tr></tr>
    <tr>

        <td>
            <c:if test="${(param.action == 'to.employee.add') || (requestScope.action == 'to.employee.add') }">
                <button type="submit" formaction="addEmployee" form="data">Add item</button>
            </c:if>

            <c:if test="${(param.action == 'to.employee.edit') || (requestScope.action == 'to.employee.edit') }">
                <button type="submit" formaction="editEmployee" form="data">Edit item</button>
            </c:if>

            <c:if test="${(param.action == 'to.employee.delete') || (requestScope.action == 'to.employee.delete') }">
                <button type="submit" formaction="deleteEmployee" form="data">Delete item</button>
            </c:if>
        </td>

        <td>
            <form id="cancel" method="get">
                <input type="hidden" name="shopId" value="${param.shopId}">
                <input type="hidden" name="shopName" value="${param.shopName}">
                <input type="hidden" name="action" value="to.employee.list">
            </form>
            <button type="submit" formaction="dispatcher" form="cancel"> Cancel </button>
        </td>
    </tr>
</table>


</body>

</html>