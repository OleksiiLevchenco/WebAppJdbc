<%--
  Created by IntelliJ IDEA.
  User: Main
  Date: 12.05.2015
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>

  <form  action="dispatcher" method="get">
    <input type="hidden" name="action" value="to.transformer.list" >
    <button type="submit">Transformers list</button>
  </form>
  <br>

  <form  action="dispatcher" method="get">
    <input type="hidden" name="action" value="to.employee.list" >
    <button type="submit">Employees list</button>
  </form>
  <br>

  <form  action="dispatcher" method="get">
    <input type="hidden" name="action" value="to.shop.list" >
    <button type="submit">Shops list</button>
  </form>
  <br>

  <form  action="dispatcher" method="get">
    <input type="hidden" name="action" value="to.shop.list" >
    <button type="submit">Shops list</button>
  </form>



  </body>
</html>
