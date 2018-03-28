/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.manager;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import problemDomain.User;
import sessionBeans.stateless.UserSLSB;

/**
 *
 * @author sufyanjami
 */
@WebServlet(name = "AddEmployee", urlPatterns = {"/AddEmployee"})
public class AddEmployee extends HttpServlet {

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
        User user =(User)session.getAttribute("user");
        Long clientID = user.getClientID();
        String username = request.getParameter("username");
        String pass = request.getParameter("pass");
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName"); 
        String lastName = request.getParameter("lastName");
        String mailingChoice = request.getParameter("mailingChoice");
        String address = request.getParameter("address");
        String role = request.getParameter("roleNumber");

        if (username != null && !username.equals("") && pass != null && !pass.equals("") && email !=null && !email.equals("")
                && firstName != null && !firstName.equals("") && lastName != null && !lastName.equals("") && mailingChoice != null
                && !mailingChoice.equals("") && address != null && !address.equals("") && role != null && !role.equals(""))
        {
            userSLSB.addEmployee(username, pass, email, firstName, lastName, mailingChoice, address, role, clientID);
            getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/manageUsers.jsp?message=Employee Added!").forward(request, response);        
        }
        else
        {
            getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/manageUsers.jsp?message=Please enter all fields.").forward(request, response);
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
