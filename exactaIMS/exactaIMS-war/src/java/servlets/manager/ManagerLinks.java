/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.manager;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dillon
 */
@WebServlet(name = "ManagerLinks", urlPatterns = {"/ManagerLinks"})
public class ManagerLinks extends HttpServlet {

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
        
            String customerAccountsLink = request.getParameter("customerAccountsLink");
            String mainLink = request.getParameter("mainLink");
            String searchLink = request.getParameter("searchLink");
            String fleetAccountsLink = request.getParameter("fleetAccountsLink");
            String manageUsersLink = request.getParameter("manageUsersLink");
            
            if (customerAccountsLink != null)
            {
                getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/customerAccounts.jsp").forward(request, response); 
            }
            else if (mainLink != null)
            {
                getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response); 
            }
            else if (searchLink != null)
            {
                getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/search.jsp").forward(request, response); 
            }
            else if (fleetAccountsLink != null)
            {
                getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/fleetAccounts.jsp").forward(request, response); 
            }
            else if (manageUsersLink != null)
            {
                getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/manageUsers.jsp").forward(request, response); 
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
