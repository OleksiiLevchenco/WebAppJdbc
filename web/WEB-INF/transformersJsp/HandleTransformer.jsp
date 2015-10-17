<%--
  Created by IntelliJ IDEA.
  User: Main
  Date: 21.04.2015
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%--@elvariable id="transformer" type="nom.lesha.firsWeb.model.Transformer"--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>handle item</title>
</head>
<body>

<%--<c:set var="transformer" value="${requestScope.transformer}"/>--%>
<c:if test="${(param.action == 'to.transformer.add') || (requestScope.action == 'to.transformer.add') }">
    <h2>Add item:</h2>
</c:if>
<c:if test="${(param.action == 'to.transformer.edit') || (requestScope.action == 'to.transformer.edit')}">
    <h2>Edit item:</h2>
</c:if>
<c:if test="${(param.action == 'to.transformer.delete') || (requestScope.action == 'to.transformer.delete')}">
    <h2>Delete item:</h2>
</c:if>

<c:if test="${requestScope.get('transformerValidationReport') != null}">
    <h2><font color="#ff7f50">Transformer validation error...</font></h2><br>
    <table cellspacing="7">
        <c:forEach var="entry" items="${transformerValidationReport}">

            <tr>
                <th><c:out value="${entry.key}"/></th>
                <td><c:out value="${entry.value}"/></td>
            </tr>

        </c:forEach>
    </table>
</c:if>

<form id="data" method="post">
    <table border="1" cellpadding="2">
        <c:if test="${(param.action == 'to.transformer.edit') || (param.action == 'to.transformer.delete') ||
                        (requestScope.action == 'to.transformer.edit') || (requestScope.action == 'to.transformer.delete')}">
            <tr>
                <th bgcolor="#ffe4c4">id</th>
                <th bgcolor="#ffe4c4">
                    <b>${transformer.id}</b>
                    <input type="hidden" name="transformer.id" value="${transformer.id}">
                </th>
            </tr>
        </c:if>
        <tr>
            <th bgcolor="#ffe4c4">Input voltage</th>
            <td><input type="text" name="inputVoltage" value="${transformer.inputVoltage}"></td>
        </tr>
        <tr>
            <th bgcolor="#ffe4c4">Output voltage</th>
            <td><input type="text" name="outputVoltage" value="${transformer.outputVoltage}"></td>
        </tr>
        <tr>
            <th bgcolor="#ffe4c4">Output current</th>
            <td><input type="text" name="outputCurrent" value="${transformer.outputCurrent}"></td>
        </tr>
        <tr>
            <th bgcolor="#ffe4c4">Mass</th>
            <td><input type="text" name="mass" value="${transformer.mass}"></td>
        </tr>
        <tr>
            <th bgcolor="#ffe4c4">Price</th>
            <td><input type="text" name="price" value="${transformer.price}"></td>
        </tr>

    </table>
</form>

<table>
    <tr></tr>
    <tr>

        <td>
            <c:if test="${(param.action == 'to.transformer.add') || (requestScope.action == 'to.transformer.add') }">
                <button type="submit" formaction="addTransformer" form="data">Add item</button>
            </c:if>

            <c:if test="${(param.action == 'to.transformer.edit') || (requestScope.action == 'to.transformer.edit') }">
                <button type="submit" formaction="editTransformer" form="data">Edit item</button>
            </c:if>

            <c:if test="${(param.action == 'to.transformer.delete') || (requestScope.action == 'to.transformer.delete') }">
                <button type="submit" formaction="deleteTransformer" form="data">Delete item</button>
            </c:if>
        </td>
        <td>
            <form id="cancel" method="post">
                <input type="hidden" name="action" value="to.transformer.list">
            </form>
            <button type="submit"
                    formaction="transformersDispatcher"
                    form="cancel">
                Cancel
            </button>
        </td>
    </tr>
</table>


</body>

</html>