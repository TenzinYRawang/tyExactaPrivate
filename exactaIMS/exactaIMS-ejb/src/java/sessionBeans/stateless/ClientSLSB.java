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
import problemDomain.Client;

/**
 *
 * @author 533925
 */
@Stateless
@LocalBean
public class ClientSLSB 
{
    String errorMessage = "";
    String table ="";
    
    /**
     * Adds all clients from database to an ArrayList of Client objects.
     * @param clients
     * @return 
     */
    public ArrayList<Client> getAllClients(ArrayList<Client> clients) 
    {
        try
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
            }
            catch (ClassNotFoundException ex)
            {
                Logger.getLogger(UserSLSB.class.getName()).log(Level.SEVERE, null, ex);
                return clients;
            }
            
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource)ic.lookup("jdbc/exactaPool");
            Connection conn = ds.getConnection();
            
            String sql = "{call getAllClients()}";
            CallableStatement cs = conn.prepareCall(sql);

            ResultSet rs = cs.executeQuery();
            
            while(rs.next())
            {
                clients.add(new Client(rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
            
            rs.close();
            cs.close();
            conn.close();
            
            return clients;
        }
        catch(NamingException | SQLException ex)
        {
            Logger.getLogger(UserSLSB.class.getName()).log(Level.SEVERE, null, ex);
            return clients;
        }
    }
    
    public void editClient(Client client)
    {
        try
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
            }
            catch (ClassNotFoundException ex)        
            {
                Logger.getLogger(UserSLSB.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource)ic.lookup("jdbc/exactaPool");
            Connection conn = ds.getConnection();
            
            String sql = "{call editClientByID(?,?,?,?,?,?,?)}";
            CallableStatement cs = conn.prepareCall(sql);
            
            cs.setLong(1, client.getClientID());
            cs.setString(2, client.getName());
            cs.setString(3, client.getCss());
            cs.setString(4, client.getLogo());
            cs.setString(5, client.getEmail());
            cs.setString(6, client.getUrl());
            cs.setString(7, client.getPhoneNumber());
            
            cs.execute();
            
            cs.close();
            conn.close();
        }
        catch (SQLException | NamingException ex)
        {
           Logger.getLogger(UserSLSB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Client addClient(String name, String css, String logo, String email, String url, String phonenumber) throws SQLException, NamingException
    {
        try
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
            }
            catch(ClassNotFoundException ex)
            {
                Logger.getLogger(UserSLSB.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource)ic.lookup("jdbc/exactaPool");
            Connection conn = ds.getConnection();
            
            String sql = "{call addClient(?,?,?,?,?,?)}";
            CallableStatement cs = conn.prepareCall(sql);
            
            cs.setString(1, name);
            cs.setString(2, css);
            cs.setString(3, logo);
            cs.setString(4, email);
            cs.setString(5, url);
            cs.setString(6, phonenumber);
            
            ResultSet rs = cs.executeQuery();
            rs.next();
            
            return new Client(rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7));
            
        }
        catch(SQLException | NamingException ex)
        {
            throw ex;
        }
    }

    public void deleteClient(Client client) 
    {
        try
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
            }
            catch(ClassNotFoundException ex)
            {
                Logger.getLogger(UserSLSB.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource)ic.lookup("jdbc/exactaPool");
            Connection conn = ds.getConnection();
            
            String sql = "{call deleteClient(?)}";
            CallableStatement cs = conn.prepareCall(sql);
            cs.setLong(1, client.getClientID());
            
            cs.execute();
            
            cs.close();
            conn.close();
        }
        catch(SQLException | NamingException ex)
        {
            Logger.getLogger(UserSLSB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
