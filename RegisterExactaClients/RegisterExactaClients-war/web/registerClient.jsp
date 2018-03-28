<%-- 
    Document   : registerClient
    Created on : Feb 11, 2018, 2:42:54 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Exacta Client</title>
    </head>
    <body>
        <h1>Exacta Information Management System Register</h1>
        <form action='RegisterClientManager' method='GET'>
            Company Name: <input type='text' name='registerClientName'><br/>
            Email: <input type='email' name='registerClientEmail'><br/>
            Phone Number: <input type='tel' name='registerClientPhoneNumber'><br/>
            Desired Domain Name (URL): <input type='text' name='registerClientUrl'><br/>
        <input type='submit' value='Submit'>
        </form>
        <%
            String registerMessage = (String) request.getAttribute("registerMessage");
            if (registerMessage!=null)
            out.println(registerMessage);
        %>
    </body>
</html>
