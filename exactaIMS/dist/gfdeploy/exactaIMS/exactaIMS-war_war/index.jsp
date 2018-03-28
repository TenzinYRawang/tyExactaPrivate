<%-- 
    Document   : login
    Created on : Feb 10, 2018, 12:43:39 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exacta - Login</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="assets/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/css/custom.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="loginSection">
            <div class="container-fluid">
                <h1>Exacta Login</h1>
                <form action='validate' method='POST'>
                    <input type="text" placeholder="Username" name="username"
                           class="form-control loginFields"/><br/>
                    <input type="password" placeholder="Password" name="password"
                           class="form-control loginFields"/><br/>
                    <input type="submit" value="Login" name="login"
                           class="btn btn-primary btn-lg btn-block loginFields"/><br/>
                </form>
            </div>
        </div>
        <div style="margin: auto">
        ${param.message}
        </div>
    </body>
</html>
