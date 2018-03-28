<%-- 
    Document   : manageUsers
    Created on : Mar 21, 2018, 2:04:52 AM
    Author     : Dillon
--%>

<%@page import="problemDomain.User"%>
<%@page import="helpers.manager.ManageUsersHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href='logout?logout='>Logout</a>
        <h3>${sessionScope.user.username}</h3>
        <form action='ManagerLinks' method='post'>
            <input type='submit' name='mainLink' value='Wash Sites'>
        </form>
        <form action='ManagerLinks' method='post'>
            <input type='submit' name='customerAccountsLink' value='Customer Accounts'>
        </form>
        <form action='ManagerLinks' method='post'>
            <input type='submit' name='fleetAccountsLink' value='Fleet Accounts'>
        </form>
        <form action='ManagerLinks' method='post'>
            <input type='submit' name='manageUsersLink' value='Manage Users'>
        </form>
        <form action='ManagerLinks' method='post'>
            <input type='submit' name='searchLink' value='Search'>
        </form>
        <h1>Manage Users</h1>
                <form action='AddEmployee' method='POST'>
                    <input type="text" placeholder="Username" name="username"/><br/>
                    <input type="text" placeholder="Password" name="pass"/><br/>
                    <input type="text" placeholder="Email" name="email"/><br/>
                    <input type="text" placeholder="first Name" name="firstName"/><br/>
                    <input type="text" placeholder="Last Name" name="lastName"/><br/>
                    <input type="text" placeholder="Mailing Choice" name="mailingChoice"/><br/>
                    <input type="text" placeholder="Address" name="address"/><br/>
                    <input type="text" placeholder="Role" name="roleNumber"/><br/>
                    <input type="submit" value="Add Employee"/><br/>
                </form>
                <br/>
                
        ${param.message}        
        <table style="border:1px solid black">
            <tr style="border:1px solid black">
            <th style="width:10%; border:1px solid black;">Username</th>
            <th style="width:10%; border:1px solid black;">Password</th>
            <th style="width:10%; border:1px solid black;">Email</th>
            <th style="width:10%; border:1px solid black;">First Name</th>
            <th style="width:10%; border:1px solid black;">Last Name</th>
            <th style="width:10%; border:1px solid black;">Mailing Choice</th>
            <th style="width:10%; border:1px solid black;">Address</th>
            <th style="width:10%; border:1px solid black;">Role</th>
            <th style="width:10%; border:1px solid black;">Edit</th>
            <th style="width:10%; border:1px solid black;">Delete</th>
        </tr>
        <%
            User user =(User)session.getAttribute("user");
            ManageUsersHelper manageUsersHelper = new ManageUsersHelper();
            out.println(manageUsersHelper.getUsersTableByClientID(user.getClientID()));
        %>
        </table>
    </body>
</html>
