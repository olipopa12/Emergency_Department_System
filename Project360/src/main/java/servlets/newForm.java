/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.LoginInfo;
import database.Main;
import database.Patients;
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
public class newForm extends HttpServlet {

    private LoginInfo user = new LoginInfo();
    private Patients patient = new Patients();

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
            Statement stmt = con.createStatement();
            // read form fields
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String address = request.getParameter("address");
            String amka = request.getParameter("amka");
            String telephone = request.getParameter("telephone");
            String insurance = request.getParameter("insurance");

            /*System.out.println("username: " + username);
            System.out.println("password: " + password);
            System.out.println("name: " + username);
            System.out.println("amka: " + amka);
            System.out.println("address: " + address);
            System.out.println("insurancee: " + insurance);
            System.out.println("telephone: " + telephone);*/
            String createLogin = user.createInfo();
            stmt.executeUpdate(createLogin);
            String createPatient = patient.createPatient();
            stmt.executeUpdate(createPatient);
            user.insertLoginInfo(Main.id, "patient", username, password);
            patient.insertPatient(Main.id, amka, firstname, lastname, insurance, address, telephone);
            Main.id++;
            request.getRequestDispatcher("index.jsp").forward(request, response);
            //con.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

}
