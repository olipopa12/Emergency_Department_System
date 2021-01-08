/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.LoginInfo;
import database.Main;
import database.Nurses;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kater
 */
public class newFormNurse extends HttpServlet {

    private LoginInfo user = new LoginInfo();
    private Nurses nurse = new Nurses();

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {

            // read form fields
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String telephone = request.getParameter("telephone");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
            Statement stmt = con.createStatement();
            String createLogin = user.createInfo();
            stmt.executeUpdate(createLogin);

            user.insertLoginInfo(Main.id, "nurse", username, password);

            String createNurse = nurse.createNurse();
            stmt.executeUpdate(createNurse);
            nurse.insertNurse(Main.id, firstname, lastname, telephone);
            Main.id++;

            request.getRequestDispatcher("index.jsp").forward(request, response);

            //con.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
