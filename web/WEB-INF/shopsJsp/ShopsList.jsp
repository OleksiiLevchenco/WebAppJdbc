<%--
  Created by IntelliJ IDEA.
  User: Main
  Date: 17.04.2015
  Time: 1:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>
        Shop management
    </title>
</head>
<body>

<h1>Shops list</h1>

<table border="2" cellpadding="5">
    <tr bgcolor="#faebd7">
        <th>id</th>
        <th>Name</th>
        <th>Address</th>
        <th>Tel</th>
        <th>Working Time</th>
        <th>Edit</th>
        <th>Delete</th>
        <th>Employees</th>
    </tr>
    <c:forEach items="${requestScope.shopsList}" var="shop">
        <tr>
                <%--<td align="center"><input type="radio" name="edit" value="${transformer.id}"></td>--%>
            <td>${shop.id}</td>
            <td>${shop.name}</td>
            <td>${shop.address}</td>
            <td>${shop.tel}</td>
            <td>${shop.workingTime}</td>

            <td bgcolor="#7fffd4">
                <form action="dispatcher" method="get">
                    <input name="shopId" type="hidden" value="${shop.id}">
                    <input name="action" type="hidden" value="to.shop.edit">
                    <input type="submit" value="Edit"/>
                </form>
            </td>
            <td bgcolor="#ffc0cb">
                <form action="dispatcher" method="get">
                    <input name="shopId" type="hidden" value="${shop.id}">
                    <input name="action" type="hidden" value="to.shop.delete">
                    <input type="submit" value="Delete"/>
                </form>
            </td>
            <td bgcolor="#ffc0cb">
                <form action="dispatcher" method="get">
                    <input name="shopId" type="hidden" value="${shop.id}">
                    <input name="shopName" type="hidden" value="${shop.name}">
                    <input name="action" type="hidden" value="to.employee.list">
                    <input type="submit" value="Employees"/>
                </form>
            </td>
            <td bgcolor="#ffc0cb">
                <form action="dispatcher" method="get">
                    <input name="shopId" type="hidden" value="${shop.id}">
                    <input name="shopName" type="hidden" value="${shop.name}">
                    <input name="action" type="hidden" value="to.employee.list">
                    <input type="submit" value="Employees"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<table>
    <tr>
        <td>
            <form action="shopsDispatcher" method="get">
                <input name="action" type="hidden" value="to.shop.add">
                <input type="submit" value="Add"/>
            </form>
        </td>
    </tr>
</table>


</body>
</html>
