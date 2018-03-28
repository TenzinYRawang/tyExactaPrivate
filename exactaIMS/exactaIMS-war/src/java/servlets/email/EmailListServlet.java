package servlets.email;

import helpers.email.EmailInvoice;
import helpers.email.MailUtilGmail;
import java.io.*;
import javax.mail.MessagingException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
//
//import murach.business.User;
//import murach.data.UserDB;
//import murach.util.*;

@WebServlet(name = "EmailListServlet", urlPatterns = {"/EmailListServlet"})
public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  // default action
        }

        // perform action and set URL to appropriate page
        String url = "/main.jsp";
        if (action.equals("join")) {
            url = "/index.jsp";    // the "join" page
        } 
        else if (action.equals("add")) 
        {
            String firstName = "FirstName";
            String surName = "SecondName";
            String email = "yhicknyan97@gmail.com";


            // send email to user
            String to = email;
            String from = "exactacapstone@murach.com";
            String subject = "Welcome to our email list";
            EmailInvoice ei = new EmailInvoice(); 
            String body = ei.getHTML();
            boolean isBodyHTML = true;

            try {
                MailUtilGmail.sendMail(to, from, subject, body, isBodyHTML);
            } catch (MessagingException e) 
            {
                String errorMessage
                        = "ERROR: Unable to send email. "
                        + "Check Tomcat logs for details.<br>"
                        + "NOTE: You may need to configure your system "
                        + "as described in chapter 14.<br>"
                        + "ERROR MESSAGE: " + e.getMessage();
                request.setAttribute("errorMessage", errorMessage);
                this.log(
                        "Unable to send email. \n"
                        + "Here is the email you tried to send: \n"
                        + "=====================================\n"
                        + "TO: " + email + "\n"
                        + "FROM: " + from + "\n"
                        + "SUBJECT: " + subject + "\n"
                        + "\n"
                        + body + "\n\n");
            }
            url = "/WEB-INF/main.jsp";
        }
//        getServletContext()
//                .getRequestDispatcher(url)
//                .forward(request, response);
//        
        getServletConfig().getServletContext().getRequestDispatcher(url).forward(request, response); 

    }
}