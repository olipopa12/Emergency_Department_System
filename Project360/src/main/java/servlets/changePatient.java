/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.Employees;
import database.LoginInfo;
import database.Patients;
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
public class changePatient extends HttpServlet {

    private LoginInfo user = new LoginInfo();
    private Patients patient = new Patients();

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {

            // read form fields
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String amka = request.getParameter("amka");
            String road = request.getParameter("road");
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String telephone = request.getParameter("telephone");
            String num = request.getParameter("number");
            String insurance = request.getParameter("insurance");
            String tk = request.getParameter("tk");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
            Statement stmt = con.createStatement();

            int ID = patient.get_id(firstname, lastname, telephone);
            patient.updatePatient(ID, amka, firstname, lastname, insurance, road, Integer.parseInt(num), Integer.parseInt(tk), telephone);

            request.getRequestDispatcher("index.jsp").forward(request, response);

            //con.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
