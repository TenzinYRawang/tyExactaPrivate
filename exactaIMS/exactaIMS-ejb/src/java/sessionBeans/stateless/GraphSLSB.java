/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans.stateless;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author 729557
 */
@Stateless
@LocalBean
public class GraphSLSB 
{
    public String errorMessage = "";


    public ArrayList<String> getRevenue() throws SQLException
    {
        
        DataSource ds = null; 
        ArrayList<String> threadList = new ArrayList<String>(); 
        try 
        { 
            ds = (DataSource)(new InitialContext().lookup("jdbc/exactaPool"));

            Connection conn = ds.getConnection();
            CallableStatement cs = conn.prepareCall("call getRevenue()");
            ResultSet rs = cs.executeQuery();

         
           // ValidateBean vb = new ValidateBean();
            String result = "";
            //result = vb.getIsAdmin(username);
            //System.out.println("ThreadResult: " + result);
            
            String money ="", date = ""; //, created="", delete=""; 
            
                       
            
                //threadList.add("Thread Title::Date/Time created::Created By::Delete Thread");
                while (rs.next()) 
                {
                    {
//                        title = "<a href='posts.jsp?threadId=" + rs.getString(1) + "'>" + rs.getString(2) + "</a>";
//                        date = rs.getString(3); //+ ":";
//                        created = rs.getString(4);
//                        delete = "<a href='Threadops?threadDelete=" + rs.getString(1) + "'>" + "Delete" + "</a>";
                        
                        money = rs.getString(1);
                        date = rs.getString(2);

                        threadList.add(money + "::" + date);
                    
                    }
                }
   
            cs.close();
            rs.close();
            conn.close();

            
        } 
        catch (NamingException ex) 
        {
            //System.out.println("Exeption Thrown");
            Logger.getLogger(GraphSLSB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
 
        return threadList;
    }
}
