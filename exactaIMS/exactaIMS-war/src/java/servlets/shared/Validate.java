package servlets.shared;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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

import sessionBeans.stateless.UserSLSB;
import utilities.Hash;

@WebServlet(name = "Validate", urlPatterns = {"/validate"})
public class Validate extends HttpServlet {

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
            throws ServletException, IOException 
    {
        String username = request.getParameter("username");
        char[] password = request.getParameter("password").toCharArray();
        
        if(username == null || username.equals("") || password == null || password.equals(""))
        {
            response.sendRedirect("index.jsp?message=Username and password required.");
        }
        else
        {
            User user = userSLSB.getUser(username);
            
            if(user == null)
            {
                response.sendRedirect("index.jsp?message=Error occured contact administrator.");
            }
            else
            {
                password = Hash.SHA256(password, user.getSalt());
                ServletContext application = getServletConfig().getServletContext();
            
                if(application.getAttribute("clients") == null)
                {
                    ArrayList<Client> clients = clientSLSB.getAllClients(new ArrayList<Client>());
                    application.setAttribute("clients", clients);
                }
                
                if(user.getUserID() == 0 || !Arrays.equals(user.getPassword(), password))
                {
                    response.sendRedirect("index.jsp?message= Wrong username or password.");
                }
                else
                {
                    HttpSession session = request.getSession();
                    session.setAttribute("user", new User(user));

                    if(user.getRole().equals(Role.getAdmin()))
                    {
                        getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);            
                    }
                    else if(user.getRole().equals(Role.getManager()))
                    {
                        getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);
                    }
                    else if(user.getRole().equals(Role.getEmployee()))
                    {
                        getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);
                    }
                    else if(user.getRole().equals(Role.getCustomer()))
                    {
                        getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/customer.jsp").forward(request, response);
                    }
                    else
                    {
                        response.sendRedirect("index.jsp");
                    }
                }
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
