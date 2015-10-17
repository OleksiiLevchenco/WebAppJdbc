<%--
  Created by IntelliJ IDEA.
  User: Main
  Date: 17.04.2015
  Time: 1:02
  To change this template use File | Settings | File Templates.
--%>
<%--@elvariable id="shop" type="nom.lesha.firsWeb.model.Shop"--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>
        Shop employees
    </title>
</head>
<body>

<%--<%request.setAttribute("employeesList", EmployeeDao.getEmployeesList()); %>--%>

<c:if test="${param.shopName != null}">
<h1><u>${param.shopName}</u> employees manager</h1>
</c:if>
<c:if test="${param.shopName == null}">
<h1>Employees list</h1>
</c:if>

<table border="2" cellpadding="5">
    <tr bgcolor="#faebd7">
        <th>id</th>
        <th>Name</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>

    <c:forEach items="${employeesList}" var="employee">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.name}</td>

                <%--Edit--%>
            <td bgcolor="#7fffd4">
                <form action="dispatcher" method="get">
                    <input name="shopId" type="hidden" value="${param.shopId}">
                    <input name="shopName" type="hidden" value="${param.shopName}">
                    <input name="employeeId" type="hidden" value="${employee.id}">
                    <input name="action" type="hidden" value="to.employee.edit">
                    <input type="submit" value="Edit"/>
                </form>
            </td>

                <%--Delete--%>
            <td bgcolor="#ffc0cb">
                <form action="dispatcher" method="get">
                    <input name="shopId" type="hidden" value="${param.shopId}">
                    <input name="shopName" type="hidden" value="${param.shopName}">
                    <input name="employeeId" type="hidden" value="${employee.id}">
                    <input name="action" type="hidden" value="to.employee.delete">
                    <input type="submit" value="Delete"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<table>
    <tr>

        <%--Add--%>
        <td>
            <form action="dispatcher" method="get">
                <input name="shopId" type="hidden" value="${param.shopId}">
                <input name="shopName" type="hidden" value="${param.shopName}">
                <input name="returnPage" type="hidden" value="${param.returnPage}">
                <input name="action" type="hidden" value="to.employee.add">
                <input type="submit" value="Add"/>
            </form>
        </td>

        <%--Return--%>
        <td>
            <form action="dispatcher" method="get">
                <input name="action" type="hidden" value="to.shop.list">
                <input type="submit" value="Return"/>
            </form>
        </td>

    </tr>
</table>