/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.LoginInfo;
import database.Patients;
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
public class changePatient extends HttpServlet {

    private LoginInfo user = new LoginInfo();
    private Patients patient = new Patients();

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

            int ID = patient.get_id(oldfirstname, oldlastname, oldtelephone);
            patient.updatePatient(ID, amka, firstname, lastname, insurance, road, Integer.parseInt(num), Integer.parseInt(tk), telephone);

            HttpSession session = request.getSession(); //Creating a session

            session.setAttribute("firstname", firstname);
            session.setAttribute("lastname", lastname);
            session.setAttribute("telephone", telephone);
            session.setAttribute("tk", tk);
            session.setAttribute("number", num);
            session.setAttribute("road", road);
            session.setAttribute("amka", amka);
            session.setAttribute("insurance", insurance);
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            request.getRequestDispatcher("employee.jsp").forward(request, response);

            //con.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
