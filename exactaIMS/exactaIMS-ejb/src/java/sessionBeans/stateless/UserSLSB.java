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
import javax.sql.DataSource;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import problemDomain.Client;

import problemDomain.User;

@Stateless
@LocalBean
public class UserSLSB 
{
    public User getUser(final String username)
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
                return null;
            }
            
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource)ic.lookup("jdbc/exactaPool");
            Connection conn = ds.getConnection();
            
            String sql = "{call getUserByUsername(?)}";
            CallableStatement cs = conn.prepareCall(sql);
            
            cs.setString(1,username);

            ResultSet rs = cs.executeQuery();
            
            if(rs.next())
            {
                User user = new User(rs.getLong(1), rs.getString(2), rs.getString(3).toCharArray(), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getInt(10), rs.getLong(11));
                
                rs.close();
                cs.close();
                conn.close();
                
                return user;
            }
            else
            {
                rs.close();
                cs.close();
                conn.close();
                
                return new User(0,null,null,null,null,null,null,0,null,0,0);
            }
        } 
        catch (NamingException | SQLException ex) 
        {
            Logger.getLogger(UserSLSB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
        public void deleteEmployee(String employeeID) {
        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("jdbc/exactaPool");
            Connection conn = ds.getConnection();
            CallableStatement cs = conn.prepareCall("call deleteEmployeeByID(?)");
            cs.setString(1, employeeID);
            cs.executeQuery();

            ic.close();
            cs.close();
            conn.close();
        } catch (SQLException | NamingException ex) {
            Logger.getLogger(UserSLSB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void addEmployee(String username, String password, String email, String firstName, String lastName, String mailingChoice, String address, String role, long clientID){
        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("jdbc/exactaPool");
            Connection conn = ds.getConnection();
            CallableStatement cs = conn.prepareCall("call addEmployee(?,?,?,?,?,?,?,?,?)");
            
            
            cs.setString(1, username);
            cs.setString(2, password);
            cs.setString(3, email);
            cs.setString(4, firstName);
            cs.setString(5, lastName);
            cs.setString(6, mailingChoice);
            cs.setString(7, address);
            cs.setString(8, role);
            cs.setLong(9, clientID);
            cs.executeQuery();
            
            
            ic.close();
            cs.close();
            conn.close();
        } catch (SQLException | NamingException ex) {
            Logger.getLogger(UserSLSB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
