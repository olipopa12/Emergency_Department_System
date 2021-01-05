/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.sql.*;
import database.LoginInfo;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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

    private LoginInfo info = new LoginInfo();

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {
           
            // read form fields
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            //String ret = info.check_role(username, password);
            String role = null;
             role = info.get_role(username,password);
            
            System.out.println(role);

            //System.out.println("username: " + username);
            // System.out.println("password: " + password);
            //gia na steiloume dedomena sthn login selida alla den mas xreiazetai pleon
            HttpSession session = request.getSession(); //Creating a session
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            if (role.equals("patient")) {
                response.sendRedirect(request.getContextPath() + "/patient");
            } else if (role.equals("doctor")) {
                response.sendRedirect(request.getContextPath() + "/doctor");
            } else if (role.equals("nurse")) {
                response.sendRedirect(request.getContextPath() + "/nurse");
            } else if (role.equals("employee")) {
                response.sendRedirect(request.getContextPath() + "/employee");
            } else {
                response.sendRedirect(request.getContextPath() + "/employee");
            }
            //request.getRequestDispatcher("login.jsp").forward(request, response);
            //con.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

}
