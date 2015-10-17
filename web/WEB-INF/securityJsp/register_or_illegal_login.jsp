<%--
  Created by IntelliJ IDEA.
  User: Main
  Date: 16.04.2015
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Transformers data base</title>
  </head>
  <body>
  <p><h1>invalid username or password</h1></p>
   <form name="loginForm" method="post" action="login">
     <table>
       <tr>
         <td>Login:</td> <td><input type="text" name="login"></td>
       </tr>
       <tr>
         <td>Password:</td> <td><input type="password" name="password"></td>
       </tr>
     </table>

     <input type="submit" value="login">
   </form>
  <form name="registrationForm" method="post" action="registration_new_user">
    <input type="submit" value="registration">
  </form>
  </body>
</html>
