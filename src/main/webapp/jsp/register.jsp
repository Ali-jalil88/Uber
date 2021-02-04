<%--
  Created by IntelliJ IDEA.
  User: Ali Jalil
  Date: 28-Jan-21
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<DOCTYPE html/>
<html lang="en">
<head>
    <title>Ali8 Jalil</title>
    <link rel="stylesheet" href="../css/test.css">
</head>
<body>
<div>
    <form action="${pageContext.request.contextPath}/controller" method="post">
        <label>FirstName</label>
        <input type="text" name="first_name" placeholder="Enter FirstName"/>
        <label>FirstName</label>
        <input type="text" name="last_name" placeholder="Enter LastName"/>
        <label>Email</label>
        <input type="text" name="email" placeholder="Enter Email"/>
        <label>Password</label>
        <input type="password" name="pass" placeholder="Enter Password"/>
        <label>Login</label>
        <input type="text" name="login" placeholder="Enter Login"/>
        <label>Type</label>
        <input type="text" name="type" placeholder="Enter Type">
        <input type="text" name="command" value="command_create_account" hidden/>
        <input type="submit" value="register"/>
    </form>
</div>
<a href="${pageContext.request.contextPath}/jsp/login.jsp">CLICK</a>
</body>
</html>
