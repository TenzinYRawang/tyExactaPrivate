<%-- 
    Document   : customer
    Created on : Mar 21, 2018, 1:43:05 AM
    Author     : Dillon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Customer</h1>
        <a href='logout?logout='>Logout</a>
        <h3>${sessionScope.user.firstName} ${sessionScope.user.lastName}</h3>
    </body>
</html>
