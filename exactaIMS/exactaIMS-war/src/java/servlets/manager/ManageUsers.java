/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.manager;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionBeans.stateless.UserSLSB;

/**
 *
 * @author sufyanjami
 */
@WebServlet(name = "ManageUsers", urlPatterns = {"/ManageUsers"})
public class ManageUsers extends HttpServlet {

    @EJB
    private UserSLSB uSLSB;

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
        response.setContentType("text/html;charset=UTF-8");

                String messageUser;
                String deleteEmployeeByID = request.getParameter("deleteEmployeeByID");
                String editEmployeeByID = request.getParameter("editEmployeeByID");
                String editedEmployee = request.getParameter("editedEmployee");
               
                if (deleteEmployeeByID != null) {
                    uSLSB.deleteEmployee(deleteEmployeeByID);
                    messageUser = "User deleted";
                    request.setAttribute("message", messageUser);
                    getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/employee.jsp").forward(request, response);
                } 

                else if (editEmployeeByID != null){            
                    getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/managerEditEmployee.jsp").forward(request, response);
                } 

                else if (editedEmployee != null){
                    messageUser = "Employee Updated!";
                    request.setAttribute("message", messageUser);
                    getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/employee.jsp").forward(request, response);

                } else {
                    response.sendRedirect("index.jsp?message=Session Expired.");

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
