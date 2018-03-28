<%-- 
    Document   : registeredClients
    Created on : Mar 4, 2018, 1:26:46 AM
    Author     : Dillon
--%>

<%@page import="exactaHelpers.AdminClientsHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registered Clients</title>
    </head>
    <body>
        <%
            String username = (String) session.getAttribute("username");
            session.setAttribute(username, username);
        %>
        ${param.userMessage}
        </br>
        <a href='Logout?logoutAdmin='>Logout</a>
        </br>
        <h1>Registered Clients</h1>
        <form action='adminlinks' method='POST'>
            <input type='submit' name='adminPageLink' value='Clients'>
        </form>
        <%
            String adminMessage = (String) request.getAttribute("adminMessage");
            if (adminMessage!=null)
            out.println(adminMessage);
        %>
         <table>
            <tr style="border:1px solid black">
            <th style="width:10%; border:1px solid black;">URL Register</th>
            <th style="width:10%; border:1px solid black;">Company Name</th>
            <th style="width:10%; border:1px solid black;">Email</th>
            <th style="width:10%; border:1px solid black;">Phone Number</th>
            <th style="width:10%; border:1px solid black;">Add Client</th>
            <th style="width:10%; border:1px solid black;">Delete</th>
        </tr>
        <%
            AdminClientsHelper ah = new AdminClientsHelper();
            out.println(ah.getAllRegisterdClientsTable());
        %>
        </table>
</html>
