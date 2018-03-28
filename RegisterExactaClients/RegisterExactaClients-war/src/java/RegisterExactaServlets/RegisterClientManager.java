/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegisterExactaServlets;

import RegisterExactaBeans.RegisterClientBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "RegisterClientManager", urlPatterns = {"/RegisterClientManager"})
public class RegisterClientManager extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @EJB
    RegisterClientBean rcb;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String registerClientName = request.getParameter("registerClientName");
        String registerClientEmail = request.getParameter("registerClientEmail");
        String registerClientPhoneNumber = request.getParameter("registerClientPhoneNumber");
        String registerClientUrl = request.getParameter("registerClientUrl");
        String registerMessage = null;
        
        if (registerClientName != null && !registerClientName.equals("") && registerClientEmail != null
                && !registerClientEmail.equals("") && registerClientPhoneNumber != null && !registerClientPhoneNumber.equals("")
                && registerClientUrl != null && !registerClientUrl.equals(""))
        {
            rcb.addRegisterClient(registerClientName, registerClientEmail, registerClientPhoneNumber, registerClientUrl);
            registerMessage = "Thanks for registering! \n Please add wash site IPV4 information.";
            request.setAttribute("registerMessage", registerMessage);
            getServletContext().getRequestDispatcher("/registerSites.jsp").forward(request, response);
        }
        else
        {
            registerMessage="Please enter all fields!";
            request.setAttribute("registerMessage", registerMessage);
            getServletContext().getRequestDispatcher("/registerClient.jsp").forward(request, response); 
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
