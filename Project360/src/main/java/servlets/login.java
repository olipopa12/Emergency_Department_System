/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.Doctor;
import java.io.IOException;
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

    private Doctor doc;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        // read form fields
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //System.out.println("username: " + username);
        // System.out.println("password: " + password);

        
        //gia na steiloume dedomena sthn login selida alla den mas xreiazetai pleon
        HttpSession session = request.getSession(); //Creating a session
        session.setAttribute("username", username);
        session.setAttribute("password", password);
        
        
        response.sendRedirect(request.getContextPath() + "/patient");
        //request.getRequestDispatcher("login.jsp").forward(request, response);
    }

}
