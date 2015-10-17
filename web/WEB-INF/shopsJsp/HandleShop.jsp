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
<c:if test="${(param.action == 'to.shop.add') || (requestScope.action == 'to.shop.add') }">
    <h2>Add item:</h2>
</c:if>
<c:if test="${(param.action == 'to.shop.edit') || (requestScope.action == 'to.shop.edit')}">
    <h2>Edit item:</h2>
</c:if>
<c:if test="${(param.action == 'to.shop.delete') || (requestScope.action == 'to.shop.delete')}">
    <h2>Delete item:</h2>
</c:if>

<c:if test="${requestScope.get('shopValidationReport') != null}">
    <h2><font color="#ff7f50">Shop validation error...</font></h2><br>
    <table cellspacing="7">
        <c:forEach var="entry" items="${shopValidationReport}">

            <tr>
                <th><c:out value="${entry.key}"/></th>
                <td><c:out value="${entry.value}"/></td>
            </tr>

        </c:forEach>
    </table>
</c:if>

<form id="data" method="post">
    <%--Show id field if edit or delete action--%>
    <table border="1" cellpadding="2">
        <c:if test="${(param.action == 'to.shop.edit') || (param.action == 'to.shop.delete') ||
                        (requestScope.action == 'to.shop.edit') || (requestScope.action == 'to.shop.delete')}">
            <tr>
                <th bgcolor="#ffe4c4">id</th>
                <th bgcolor="#ffe4c4">
                    <b>${shop.id}</b>
                    <input type="hidden" name="shopId" value="${shop.id}">
                </th>
            </tr>
        </c:if>
        <tr>
            <th bgcolor="#ffe4c4">Name</th>
            <td><input type="text" name="shopName" value="${shop.name}"></td>
        </tr>
        <tr>
            <th bgcolor="#ffe4c4">Address</th>
            <td><input type="text" name="shopAddress" value="${shop.address}"></td>
        </tr>
        <tr>
            <th bgcolor="#ffe4c4">Tel</th>
            <td><input type="text" name="shopTel" value="${shop.tel}"></td>
        </tr>
        <tr>
            <th bgcolor="#ffe4c4">Working time</th>
            <td><input type="text" name="shopWorkingTime" value="${shop.workingTime}"></td>
        </tr>

    </table>
</form>

<table>
    <tr></tr>
    <tr>

        <td>
            <c:if test="${(param.action == 'to.shop.add') || (requestScope.action == 'to.shop.add') }">
                <button type="submit" formaction="addShop" form="data">Add item</button>
            </c:if>

            <c:if test="${(param.action == 'to.shop.edit') || (requestScope.action == 'to.shop.edit') }">
                <button type="submit" formaction="editShop" form="data">Edit item</button>
            </c:if>

            <c:if test="${(param.action == 'to.shop.delete') || (requestScope.action == 'to.shop.delete') }">
                <button type="submit" formaction="deleteShop" form="data">Delete item</button>
            </c:if>
        </td>
        <td>
            <form id="cancel" method="get">
                <input type="hidden" name="action" value="to.shop.list">
            </form>
            <button type="submit"
                    formaction="dispatcher"
                    form="cancel">
                Cancel
            </button>
        </td>
    </tr>
</table>


</body>

</html>