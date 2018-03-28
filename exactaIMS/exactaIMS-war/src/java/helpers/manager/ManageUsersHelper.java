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
public class ManageUsersHelper
{
String table ="";
    public String getUsersTableByClientID(Long clientID)
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
            String usersSql = "{call getUsersByClientID(?)}";
            CallableStatement csUsers = conn.prepareCall(usersSql);
            csUsers.setLong(1, clientID);
            ResultSet rsUsers = csUsers.executeQuery();
            String role = "";
            while (rsUsers.next())
            {
                switch (rsUsers.getInt(10)) {
                    case 2:
                        role = "Manager";
                        break;
                    case 1:
                        role = "Employee";
                        break;
                    case 0:
                        role = "Customer";
                        break;
                    default: 
                        break;
                }
                table += "<tr style=\"border:1px solid black\"><td style=\"width:10%; border:1px solid black;\">" + rsUsers.getString(2) + "</td>" +
                        "<td style=\"width:10%; border:1px solid black;\">" + rsUsers.getString(3) + "</td>" +
                        "<td style=\"width:10%; border:1px solid black;\">" + rsUsers.getString(5) + "</td>" +
                        "<td style=\"width:10%; border:1px solid black;\">" + rsUsers.getString(6) + "</td>" +
                        "<td style=\"width:10%; border:1px solid black;\">" + rsUsers.getString(7) + "</td>" +
                        "<td style=\"width:10%; border:1px solid black;\">" + rsUsers.getInt(8) + "</td>" +
                        "<td style=\"width:10%; border:1px solid black;\">" + rsUsers.getString(9) + "</td>" +
                        "<td style=\"width:10%; border:1px solid black;\">" + role + "</td>" +
                        "<td style=\"width:10%; border:1px solid black;\">Edit</td>" +
                        "<td style=\"width:10%; border:1px solid black;\"><a onclick=\"return confirm('Are you sure you want to Delete User?');\" href='DeleteUser?deleteUserID=" + rsUsers.getString(1) +"'>Delete</td></tr>";
            }
            csUsers.close();
            rsUsers.close();
            conn.close();   
        }
        catch (SQLException | NamingException ex)
        {
            Logger.getLogger(ManageUsersHelper.class.getName()).log(Level.SEVERE, null, ex);
            table = "Could not execute SQL";
        }
        return table;
    }  
        
}
