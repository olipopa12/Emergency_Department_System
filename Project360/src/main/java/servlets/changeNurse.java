/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.Nurses;
import database.LoginInfo;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class changeNurse extends HttpServlet {

    private LoginInfo user = new LoginInfo();
    private Nurses nurse = new Nurses();

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {
            String oldfirstname = "";
            String oldlastname = "";
            String oldtelephone = "";
            oldfirstname += request.getSession(false).getAttribute("firstname");
            oldlastname += request.getSession(false).getAttribute("lastname");
            oldtelephone += request.getSession(false).getAttribute("telephone");
            // read form fields
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String telephone = request.getParameter("telephone");
            /*String oldfirstname = request.getParameter("oldfirstname");
            String oldlastname = request.getParameter("oldlastname");
            String oldtelephone = request.getParameter("oldtelephone");*/
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
            Statement stmt = con.createStatement();

            //int ID = nurse.get_id(oldfirstname, oldlastname, oldtelephone);
            int ID = nurse.get_id(oldfirstname, oldlastname, oldtelephone);
            nurse.updateNurse(ID, firstname, lastname, telephone);

            HttpSession session = request.getSession(); //Creating a session

            session.setAttribute("firstname", firstname);
            session.setAttribute("lastname", lastname);
            session.setAttribute("telephone", telephone);
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            request.getRequestDispatcher("nurse.jsp").forward(request, response);

            //con.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
