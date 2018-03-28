<%-- 
    Document   : fleetAccounts
    Created on : Mar 21, 2018, 2:02:47 AM
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
        <a href='logout?logout='>Logout</a>
        <h3>${sessionScope.user.firstName} ${sessionScope.user.lastName}</h3>
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
        <h1>Fleet Accounts</h1>
    </body>
</html>
