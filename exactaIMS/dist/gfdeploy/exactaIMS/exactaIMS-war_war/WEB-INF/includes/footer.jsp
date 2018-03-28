
<%--<%@page import="helper.GraphDataHelper"%>--%>
<!--FOOTER -->
<footer>
  <div class="container">
    <div class="col-sm-3">
      <!-- <p><a href="/"><img src=""
        alt="Comany img"</a></p> -->
    </div> <!-- end col -->
    <div class="col-sm-6">
      <nav>
        <ul class="list-unstyled list-inline">
          <li><a href="">Home</a></li>
          <li><a href="">Blog</a></li>
          <li><a href="">Resources</a></li>
          <li><a href="">Contact</a></li>
          <li class="signup-link"><a href="">Sign up now</a></li>
        </ul>

      </nav>
    </div> <!-- end col -->
    <div class="col-sm-3">
      <p class="pull-right">&copy; 2018 Exacta</p>
    </div> <!-- end col -->
  </div> <!-- end div -->
</footer>
  <!-- End of FOOTER -->

  
    <!-- CHART.JS  --> 
  <!--<script src="JS/graphs.js"></script>-->

  <!--JAVASCRIPT  -->  
  <script type="text/javascript">


    var rChart = document.getElementById("revenueGraph").getContext('2d');
      var vChart = document.getElementById("vehicleGraph").getContext('2d');

        Chart.defaults.global.defaultFontFamily ='Lato';
        Chart.defaults.global.defaultFontSize = 18;
        Chart.defaults.global.defaultFontColor = '#777';

      var vGraph = new Chart(vChart, {
        type:'bar', //bar, horizontalBar, pie, line, dougnut, radar, polarArea
        data:{

          labels:['8:00 AM', '9:00 AM', '10:00 AM', '11:00 AM', '12:00 AM', '1:00 PM',
                  '2:00 PM', '3:00 PM', '4:00 PM', '5:00 PM', '6:00 PM'],
          datasets:[{
            label: 'Population',
            data:[
                3,
                5,
                2,
                6,
                1,
                3,
                12,
                2,
                12,
                20,
                2
            ],
            //backgroundColor: 'green'
            backgroundColor:[
              'rgba(255, 99, 132, 0.6)',
              'rgba(54, 162, 132, 0.6)',
              'rgba(255, 206, 132, 0.6)',
              'rgba(75, 192, 132, 0.6)',
              'rgba(153, 102, 132, 0.6)',
              'rgba(255, 159, 132, 0.6)',
            ],
            borderWidth:1,
            borderColor:'#777',
            hoverBorderWidth:'3',
            hoverBorderColor:'#000'
          }]
        }, //data is an object
        options:{
          title:{
            display:true,
            text:'Vechile Count Per Hour',
            fontSize:25
          },
          legend:{
            display: false,
            position:'right',
            labels:{
              fontColor:'#000'
            }
          },
          layout:{
            padding:{
              left:0,
              right:0,
              bottom:0,
              top:0
            }
          },
          tooltips:{
            enabled:false
          }
        }
      });





       let rGraph = new Chart(rChart, {
         type:'line', //bar, horizontalBar, pie, line, dougnut, radar, polarArea
         data:{
           labels:[
                    <%

                        //GraphDataHelper gdb = new GraphDataHelper();
                        //out.println(gdb.getxAxis()); 
                    %>
           ],
           datasets:[{
             label: 'Revenue',
             data:[

                 <%
                 //out.println(gdb.getyAxis()); 
                 %>
             ],
             //backgroundColor: 'green'
             backgroundColor:[
               'rgba(255, 99, 132, 0.6)',
               'rgba(54, 162, 132, 0.6)',
               'rgba(255, 206, 132, 0.6)',
               'rgba(75, 192, 132, 0.6)',
               'rgba(153, 102, 132, 0.6)',
               'rgba(255, 159, 132, 0.6)',
             ],
             borderWidth:1,
             borderColor:'#777',
             hoverBorderWidth:'3',
             hoverBorderColor:'#000'
           }]
         }, //data is an object
         options:{
           title:{
             display:true,
             text:'Total Revenue Per Hour',
             fontSize:25
           },
           legend:{
             display: false,
             position:'right',
             labels:{
               fontColor:'#000'
             }
           },
           layout:{
             padding:{
               left:0,
               right:0,
               bottom:0,
               top:0
             }
           },
           tooltips:{
             // enabled:false
           }
         }
       });
    </script>
            
</body>
</html>

