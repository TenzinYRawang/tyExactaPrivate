/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers.manager;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


/**
 *
 * @author Dillon
 */
public class WashSitesHelper {
    
    String table ="";
    
    public String getWashSitesByClientID(Long clientID)
    {
        try
        {
            try
            {
               Class.forName("com.mysql.jdbc.Driver"); 
            }
            catch (ClassNotFoundException e)
            {
                table = "Couldnt find the Driver"; 
            }
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("jdbc/exactaPool");
            Connection conn = ds.getConnection();
            String washSitesSql = "{call getWashSitesByClientID(?)}";
            CallableStatement csWashSites = conn.prepareCall(washSitesSql);
            csWashSites.setLong(1, clientID);
            ResultSet rsWashSites = csWashSites.executeQuery();
            
            while (rsWashSites.next())
            {
                table += "<tbody> "
                            + "<tr><td>" 
                                + rsWashSites.getString(4) + "</td>" +
                                 "<td>" + rsWashSites.getString(2) + "</td>" +
                                 "<td>" + rsWashSites.getInt(5) + "</td>"
                            + "</tr> "
                        + "</tbody>";
            }
            
//            <section class="washSites">
//                    <h1 style="text-align: center">Barlow Bubble Wash</h1>
//
//                  <div class="container">
//                    <table  class="table table-hover">
//                    <thead>
//                      <tr>
//                        <th scope="col">#</th>
//                        <th scope="col">Total Revenue</th>
//                        <th scope="col">Vehicle Count</th>
//                        <th scope="col">Open/Closed</th>
//                        <th scope="col">Bays Active</th>
//                        <th scope="col">Location</th>
//                        <th scope="col">Description</th>
//                      </tr>
//                    </thead>
//                    <tbody>
//                      <tr>
//                        <th scope="row">1</th>
//                        <td>$347.98</td>
//                        <td>23</td>
//                        <td style="color:green">Open</td>
//                        <td>4</td>
//                        <td>3</td>
//                        <td>4591 25 St SE</td>
//                      </tr>
//                    </tbody>
//                  </table>
//                </div>
//                </div>
//
//
//            </section>
//            
            
            csWashSites.close();
            rsWashSites.close();
            conn.close();   
        }
        catch (SQLException | NamingException ex)
        {
            Logger.getLogger(WashSitesHelper.class.getName()).log(Level.SEVERE, null, ex);
            table = "Could not execute SQL";
        }
        return table;
    }
}
