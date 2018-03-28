

     <!--NOW USING JSTL TO BRING HEADER FROM header.jsp-->
     <%@ include file="includes/header.jsp" %>


        <section class="graphs">
            <h1 style="text-align: center">Wash Sites</h1>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th scope="col">Wash Site Name</th>
                            <th scope="col">Address</th>
                            <th scope="col">Number of Bays</th>
                        </tr>
                    </thead>
                    <% 
                        User user =(User)session.getAttribute("user");
                        WashSitesHelper wh = new WashSitesHelper();      
                        out.println(wh.getWashSitesByClientID(user.getClientID()));
                    %>
                </table>
        </section>    
        
            
        <section class="invoiceSection">
            <div id= "invoiceStructure"> 
                <div  id = "invoiceTitle"> 
                    Invoice
                </div>
                <div id= "invoiceBody"> 
                    <div style="width:30%; float:left;padding:10px;">

                        <span style="font-size:14px;float:left; width:100%;">
                            Josh
                        </span>
                                     <span style="font-size:14px;float:left;width:100%;">
                            33, eglington street , 
                                            james
                        </span>
                                    <span style="font-size:14px;float:left;width:100%;">
                                    johnny@yahoo.com
                                    </span>
                    </div>

                    <div id="invoiceDate">
                    <span>
                            <b>Date: </b>2018-23-03
                    </span>
                    <span>
                           <b>Invoice# : </b>123456
                    </span>
                    </div>
                </div>
                <form action="EmailListServlet" method="post">
                    <input type="hidden" name="action" value="add">        
                    <button type="submit" class="btn btn-secondary btn-sm">Email</button>
                </form>
                
                <form action= "PrintServlet" method="post">
                    <input type="hidden" value="printInvoice">
                    <button type="submit" class="btn btn-primary btn-sm">Print</button>
                </form>
            </div>    
        </section> 
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                
        <section class="graphs">

            <div class="container">
              <div class="row">
                <div class="col-sm-5">
                  <!-- <h2>Vehicle Count Per Hour</h2> -->
                  <!-- <img src="assets/img/graph1.png" class="img-rounded" alt="Cinque Terre" width="304" height="236"> -->
                  <canvas id="revenueGraph"></canvas>

                </div> <!-- col -->
                  <div class="col-sm-5">
                    <!-- <h2>Total Revenue Per Hour</h2> -->
                    <!-- <img src="assets/img/graph2.png" class="img-rounded" alt="Cinque Terre" width="304" height="236"> -->
                    <canvas id="vehicleGraph"></canvas>

                  </div>  <!-- col -->
                  <div class="col-sm-2">
                    <table  class="table table-hover">
                    <thead>
                      <tr>
                        <th scope="col">Bay Number</th>
                        <th scope="col">Status</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <th scope="row">1</th>
                        <td  style="color:green">Open</td>
                      </tr>
                    </tbody>
                  </table>

                  </div><!--col  -->

                </div> <!-- row -->
              </div> <!-- container -->
            </div>
        </section>
            
    <%@ include file="includes/footer.jsp" %>
