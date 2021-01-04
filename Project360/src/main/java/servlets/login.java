/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kater
 */
public class login extends HttpServlet {
    
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        // read form fields
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        
        HttpSession session = request.getSession(); //Creating a session
        //session.setAttribute("type", type); //setting session attribute
        session.setAttribute("username", username);
        session.setAttribute("password", password);
        
      
       response.sendRedirect(request.getContextPath()+"/emfanisi");
        //request.getRequestDispatcher("login.jsp").forward(request, response);
    }
    
}
