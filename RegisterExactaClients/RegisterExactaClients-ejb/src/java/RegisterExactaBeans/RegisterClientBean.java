/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegisterExactaBeans;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class RegisterClientBean
{

int registerID; 
public String errorMessage = "";

    public int getRegisterID() 
    {
        return registerID;
    }

    public void setThreadID(int registerID) 
    {
        this.registerID = registerID;
    }
    
    public void addRegisterClient (String registerClientUrl, String registerClientName, String registerClientEmail, String registerClientPhoneNumber)
    {
        try
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
            }
            catch (ClassNotFoundException e)        
            {
                errorMessage = "Couldnt find the Driver";
            }
            
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("jdbc/exactadbPool");
            Connection conn = ds.getConnection();
            String addRegisterClientSql = "{call addRegisterClient(?, ?, ?, ?)}";
            CallableStatement csAddRegisterClient = conn.prepareCall(addRegisterClientSql);
            csAddRegisterClient.setString(1, registerClientUrl);
            csAddRegisterClient.setString(2, registerClientName);
            csAddRegisterClient.setString(3, registerClientEmail);
            csAddRegisterClient.setString(4, registerClientPhoneNumber);
            csAddRegisterClient.executeQuery();
            
            csAddRegisterClient.close();
            conn.close();
        }
        catch (SQLException | NamingException ex)
        {
           Logger.getLogger(RegisterClientBean.class.getName()).log(Level.SEVERE, null, ex);
           errorMessage = "Could not execute SQL"; 
        }
    }
}
