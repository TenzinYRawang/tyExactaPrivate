
<%@page import="java.util.ArrayList"%>
<%--<%@page import="exactaBean.GraphDataBean"%>--%>
<%--<%@page import="helper.GraphDataHelper"%>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="t" %>--%>

<!--Dillion's import-->

<%@page import="problemDomain.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="helpers.manager.WashSitesHelper"%>
<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>


<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="icon" href="assets/img/exactaLogo.png">
  <title>Wash Sites</title>
  
    <!-- FONT AWESOME  -->
  <script src="https://use.fontawesome.com/16cb25d3d6.js"></script>
  <!-- <link href="assets/css/fontawesome/css/fontawesome.min.css" rel="stylesheet"> -->

  <!-- BOOTSTRAP CDN  -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <!-- <link href="assets/css/bootstrap.min.css" rel="stylesheet"> -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <!-- CHART.JS  --> 
  <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.min.js"></script>
  
  <!-- CUSTOM CSS --> 
  <!--<link href="CSS/custom.css" rel="stylesheet">-->
  <style>
      body {
		/* background: url('../img/tile.jpg') top left repeat; */
}
.search {
  padding-top: 10px;
}

.exactaLogo {
  max-width: 10%;
  max-height: 10%;
}
.navbar-brand {
  max-width: 10%;
  max-height: 10%;
}

.washSites
{
  padding-top: 50px;
  /* background-color: grey; */
  /* max-width: 80px; */
}




.table {
  max-width: 80%;
  margin-left: AUTO;
  margin-right: AUTO;

}

.graphs  {
  padding-top: 50px;
  padding-bottom: 25px;
}

.googleMap {
  padding-top: 80px;
  padding-bottom: 25px;
  padding-left: 150px;
  margin-left: auto;
  margin-right: auto;
}
#map {
  height: 300px;
  width: 80%;
}


.loginFields {
  max-width: 350px !important;
	margin: auto;
}
.loginSection {
	margin: auto;
	width: 350px;
}
.table
{
  padding-right: 100px;
}

.miniMenu {
  padding-top: 30px;
  text-align: center;

}

.miniMenu a:link {
color: Black;
text-decoration: none;
}

.sidebar {
  margin: 0;
  padding: 0;
}

.sidebar ul {
  margin: 0;
  padding: 15px;

}

.sidebar li {
  text-align: center;
  width: 18%;
  margin-bottom: 3px !important;
  /* background-color: #fff; */
  /* border: 1px solid #eee; */
  display: inline-block;
}

.sidebar i {
  display: block;
  font-size: 40px;
  color: black;
}

.sidebar a:hover {
  color: gold;
}

footer {
  background-color: black;
  background: #3e4249;
  color: white;
  padding: 20px 0 10px;
  font-size: 12 px;
  margin-top: 150px;
  /*position: absolute;*/
/*  left: 0;
  bottom: 0;*/
  width: 100%;

}

footer p {
  margin: 0;
}

footer a:link, footer a:visited {
  color: white;
}

footer a:hover {
  color: #dd5638;
}

footer li.signup-link a {
  color: #dd5638;
}

footer li.signup-link a:hover {
  font-weight: bold;
}

/* CSS FOR INVOICE */

#invoiceSection {
    float:right; 
    padding-bottom: 50px;
}
#invoiceStructure {
  margin:5% 40% 0% 33%;
  float:left; 
  width:500px;
  box-shadow:0 0 3px #aaa;
  height:auto;
  color:#666;
}

#invoiceTitle {
  width:100%;
  padding:10px;
  float:left;
  background:#1ca8dd;
  color:#fff;
  font-size:30px;
  text-align:center;

}

#invoiceBody {
  width:100%;
  padding:0px 0px;
  border-bottom:1px solid rgba(0,0,0,0.2);
  float:left;
}

#invoiceDate {
    width:40%; 
    float:right;
    /*padding:;*/
}

#invoiceDate span {
   font-size:14px;
   float:right;  
   padding:10px; 
   text-align:right; 
}
  </style>
</head>

<body>
<!-- HEADER
=============================================================== -->
<header>
  <div class="navbar-wrapper">

    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" 
                  data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>

          <!--TODO have to put company logo there  -->
          <!-- <a class="navbar-brand" href="/"><img src="assets/img/exactaLogo.png" alt="ExactaLogo"></a> -->


        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li class="active"><a href="ManagerLinks?mainLink=mainLink">Wash Sites</a></li>
            <li class=""><a href="ManagerLinks?customerAccountsLink=customerAccountsLink">Customer Accounts</a></li>
            <li class=""><a href="ManagerLinks?fleetAccountsLink=fleetAccountsLink">Fleet Accounts</a></li>
            <li class=""><a href="ManagerLinks?manageUsersLink=manageUsersLink">Manage Users</a></li>
            <li class=""><a href="ManagerLinks?searchLink=searchLink">Search</a></li>

            <!--<li class="search"> <input class="form-control" type="search" name="search" placeholder="Search"></li>-->
            <!--<li><a href="signUp.html"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>-->
            <li><a href="logout?logout=Logout'"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</header>
<!-- mini Menu BAR  --> -->
<section class="miniMenu ">
  <div class="sidebar breadcrumb">
    <ul>
      <li>
      <a href="URL-HERE" title="Dashboard" ><i class="fa fa-tachometer"></i><span>Dashboard</span></a></li>

      <li><a href="URL-HERE" title="Promotion" ><i class="fa fa-product-hunt "></i><span>Promotion</span></a>
      </li>

      <li><a href="URL-HERE" title="Manager" ><i class="fa fa-user"></i><span>Manage</span></a>
      </li>

      <li><a href="URL-HERE" title="Bay Selection"><i class="fa fa-check"></i><span>Bay Selection</span></a>
      </li>

      <li>  <a href="URL-HERE" title="Time Selection"><i class="fa fa-calendar"></i><span>Time Selection</span></a>
      </li>
    </ul>
  </div>
</section>
