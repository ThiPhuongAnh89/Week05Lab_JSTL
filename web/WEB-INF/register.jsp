<%-- 
    Document   : register
    Created on : 7-Feb-2020, 8:41:50 AM
    Author     : 794458-787900
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="" method="POST">
        Username: <input type="text" name="usernameLogin">
        <input type="hidden" name="action" value="register">
        <input type="submit" value="Register name">
       </form>
       ${message}
        </body>
</html>
