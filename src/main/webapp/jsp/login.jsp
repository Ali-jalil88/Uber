<%--
  Created by IntelliJ IDEA.
  User: Ali Jalil
  Date: 28-Jan-21
  Time: 3:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<div>
    <form action="${pageContext.request.contextPath}/controller" method="post">
        <label>Login</label>
        <input type="text" name="login" placeholder="Enter Login">
        <label>Password</label>
        <input type="password" name="pass" placeholder="Enter Password">

        <input type="submit" value="submit">
        <input type="text" name="command" value="command_login_account" hidden/>
    </form>
</div>

</body>
</html>
