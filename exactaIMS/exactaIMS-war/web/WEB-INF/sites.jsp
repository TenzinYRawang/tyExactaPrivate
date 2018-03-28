<%-- 
    Document   : sites
    Created on : Mar 7, 2018, 10:36:04 AM
    Author     : 533925
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!SiteHelper siteHelper = new SiteHelper();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%=siteHelper.getSiteTable(request.getParameter("siteid"), application)%>
    </body>
</html>
