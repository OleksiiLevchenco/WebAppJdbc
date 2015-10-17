<%--
  Created by IntelliJ IDEA.
  User: Main
  Date: 17.04.2015
  Time: 1:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>
      Transformers management
    </title>
</head>
<body>

<h1>Transformers list</h1>

<table border="2" cellpadding="5">
    <tr bgcolor="#faebd7">
        <th>id</th>
        <th>Input voltage</th>
        <th>Output voltage</th>
        <th>Output current</th>
        <th>Mass</th>
        <th>Price</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${requestScope.transformersList}" var="transformer">
        <tr>
            <td>${transformer.id}</td>
            <td>${transformer.inputVoltage}</td>
            <td>${transformer.outputVoltage}</td>
            <td>${transformer.outputCurrent}</td>
            <td>${transformer.mass}</td>
            <td>${transformer.price}</td>
            <td bgcolor="#7fffd4">
                <form action="dispatcher" method="post">
                    <input name="transformer.id" type="hidden" value="${transformer.id}">
                    <input name="action" type="hidden" value="to.transformer.edit">
                    <input type="submit" value="Edit"/>
                </form>
            </td>
            <td bgcolor="#ffc0cb">
                <form action="dispatcher" method="post">
                    <input name="transformer.id" type="hidden" value="${transformer.id}">
                    <input name="action" type="hidden" value="to.transformer.delete">
                    <input type="submit" value="Delete"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<table>
    <tr>
        <td>
            <form action="dispatcher" method="post">
                <input name="action" type="hidden" value="to.transformer.add">
                <input type="submit"  value="Add"/>
            </form>
        </td>
    </tr>
</table>


</body>
</html>
