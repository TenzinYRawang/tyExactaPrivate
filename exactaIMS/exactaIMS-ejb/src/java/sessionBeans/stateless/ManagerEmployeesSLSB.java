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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author 673314
 */
public class ManagerEmployeesSLSB {
    String table ="";
    
    public String getAllEmployeesTable()
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
            String allEmployeesSQL = "{call getAllEmployees()}";
            CallableStatement csAllEmployees = conn.prepareCall(allEmployeesSQL);
            ResultSet rsAllEmployees = csAllEmployees.executeQuery();

            while (rsAllEmployees.next())
            {
                table += "<tr style=\"border:1px solid black\"><td style=\"width:10%; border:1px solid black;\">" + rsAllEmployees.getString(1) + "</td>" + " " +
                        "<td style=\"width:10%; border:1px solid black;\">" + rsAllEmployees.getString(2) + "</td>" + " " +
                        "<td style=\"width:10%; border:1px solid black;\">" + rsAllEmployees.getString(3) + "</td>" + " " +
                        "<td style=\"width:10%; border:1px solid black;\">" + rsAllEmployees.getString(5) + "</td>" + " " +
                        "<td style=\"width:10%; border:1px solid black;\">" + rsAllEmployees.getString(6) + "</td>" + " " +
                        "<td style=\"width:10%; border:1px solid black;\">" + rsAllEmployees.getString(7) + "</td>" + " " +
                        "<td style=\"width:10%; border:1px solid black;\"><a href='ManageUsers?editEmployeeByID=" + rsAllEmployees.getString(1) +"'>Edit</a></td>" + " " +
                        "<td style=\"width:10%; border:1px solid black;\"><a href='ManageUsers?deleteEmployeeByID=" + rsAllEmployees.getString(1) +"'>Delete</a></td></tr></br>";


           }
            csAllEmployees.close();
            rsAllEmployees.close();
            conn.close();   
        }
        catch (SQLException | NamingException ex)
        {
            Logger.getLogger(ManagerEmployeesSLSB.class.getName()).log(Level.SEVERE, null, ex);
            table = "Could not execute SQL";
        }
        return table;
    }
    
    
    
}
