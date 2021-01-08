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

            // read form fields
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String telephone = request.getParameter("telephone");
            String specialty = request.getParameter("specialty");

            System.out.println("firstname: " + firstname);
            System.out.println("lastname: " + lastname);
            System.out.println("telephone: " + telephone);
            System.out.println("specialty: " + specialty);

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
            Statement stmt = con.createStatement();

            int ID = doctor.get_id(firstname, lastname, telephone);
            System.out.println("id: " + ID);
            System.out.println("firstname: " + firstname);
            System.out.println("lastname: " + lastname);
            System.out.println("telephone: " + telephone);
            System.out.println("specialty: " + specialty);
            doctor.updateDoctor(ID, firstname, lastname, specialty, telephone);
            request.getRequestDispatcher("index.jsp").forward(request, response);

            //con.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
