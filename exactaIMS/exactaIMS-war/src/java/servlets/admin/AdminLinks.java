/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.admin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import problemDomain.User;
import sessionBeans.stateless.ClientSLSB;
import sessionBeans.stateless.UserSLSB;

/**
 *
 * @author Dillon
 */
@WebServlet(name = "AdminLinks", urlPatterns = {"/adminlinks"})
public class AdminLinks extends HttpServlet {
    
    @EJB
    private ClientSLSB clientSLSB;

    @EJB
    private UserSLSB userSLSB;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String addClientLink = request.getParameter("addClientLink");
        String adminPageLink = request.getParameter("adminPageLink");
        String registeredClientsLink = request.getParameter("registeredClientsLink");
        String username = (String) session.getAttribute("username");
        User user = userSLSB.getUser(username);
        
        //Add Client link from admin.jsp
        if (addClientLink != null)
        {
            session.setAttribute("username", user.getUsername());
            getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/adminAddClient.jsp?userMessage="
            + user.getFirstName() + " " + user.getLastName()).forward(request, response);
        }
        //admin page link from adminRegisteredClinets.jsp
        else if (adminPageLink != null)
        {
            session.setAttribute("username", user.getUsername());
            getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp?userMessage="
            + user.getFirstName() + " " + user.getLastName()).forward(request, response);  
        }
        //Registered Clients page link from admin.jsp
        else if (registeredClientsLink != null)
        {
            session.setAttribute("username", user.getUsername());
            getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/registeredClients.jsp?userMessage="
            + user.getFirstName() + " " + user.getLastName()).forward(request, response);  
        }
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
