/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import problemDomain.Client;
import problemDomain.Role;
import problemDomain.User;
import sessionBeans.stateless.ClientSLSB;

/**
 *
 * @author Dillon
 */
@WebServlet(name = "DeleteClient", urlPatterns = {"/deleteclient"})
public class DeleteClient extends HttpServlet {

    @EJB
    private ClientSLSB clientSLSB;

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
            throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        
        if(!user.getRole().equals(Role.getAdmin()))
        {
            session.invalidate();
            response.sendRedirect("index.jsp?message=Not logged in as admin.");
        }
        else
        {
            ServletContext application = getServletConfig().getServletContext();
            try
            {
                long id = Long.parseLong(request.getParameter("id"));
                ArrayList<Client> clients = (ArrayList<Client>)application.getAttribute("clients");
                
                for(int i = 1; i < clients.size(); i++)
                {
                    if(clients.get(i).getClientID() == id)
                    {
                        Client client = clients.remove(i);
                        clientSLSB.deleteClient(client);
                    }
                }
                
                getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
            }
            catch(NumberFormatException e)
            {
                response.sendRedirect("index.jsp");
            }
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
