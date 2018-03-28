<%@page import="helpers.admin.ClientHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%!ClientHelper clientHelper = new ClientHelper();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exacta - Administrator Dashboard</title>
        <script src="js/ajax/ajaxfunctions.js" type="text/javascript"></script>
    </head>
    <body>
        <%=clientHelper.getClientTable(application)%>
        <a href="#clientform" onclick="loadaddclient();">Add Client</a>
        <div id="clientform">
        </div>
    </body>
</html>
