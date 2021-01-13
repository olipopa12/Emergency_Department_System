/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.Doctors;
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
public class changeDoctor extends HttpServlet {

    private LoginInfo user = new LoginInfo();
    private Doctors doctor = new Doctors();

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
            String firstname = request.getParameter("firstname");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String lastname = request.getParameter("lastname");
            String telephone = request.getParameter("telephone");
            String specialty = request.getParameter("specialty");
            /*System.out.println("firstname: " + firstname);
            System.out.println("lastname: " + lastname);
            System.out.println("telephone: " + telephone);
            System.out.println("specialty: " + specialty);
            System.out.println("oldfirstname: " + oldfirstname);
            System.out.println("oldlastname: " + oldlastname);
            System.out.println("oldtelephone: " + oldtelephone);*/

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
            Statement stmt = con.createStatement();

            //int ID = doctor.get_id(firstname, lastname, telephone);
            int ID = doctor.get_id(oldfirstname, oldlastname, oldtelephone);
            //System.out.println("id: " + ID);
            doctor.updateDoctor(ID, firstname, lastname, specialty, telephone);

            HttpSession session = request.getSession(); //Creating a session

            session.setAttribute("firstname", firstname);
            session.setAttribute("lastname", lastname);
            session.setAttribute("specialty", specialty);
            session.setAttribute("telephone", telephone);
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            request.getRequestDispatcher("doctor.jsp").forward(request, response);

            //con.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
