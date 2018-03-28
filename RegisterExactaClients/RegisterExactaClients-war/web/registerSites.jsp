<%-- 
    Document   : registerSites
    Created on : Feb 11, 2018, 2:43:28 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Sites</title>
    </head>
    <body>
        <h1>Thanks for Registering!</h1>
        <h1>Register Sites</h1>
        <%
            String registerMessage = (String) request.getAttribute("registerMessage");
            if (registerMessage!=null)
            out.println(registerMessage);
        %>
        <form action='RegisterClientManager' method='GET'>
            Wash Site IPV4: <input type='text' name='washSiteRegisterIPV4'><br/>
        <input type='submit' value='Add'>
        </form>
    </body>
</html>
