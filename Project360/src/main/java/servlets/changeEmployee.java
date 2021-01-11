/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.Employees;
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
public class changeEmployee extends HttpServlet {

    private LoginInfo user = new LoginInfo();
    private Employees employee = new Employees();

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {

            // read form fields
            String oldfirstname = "";
            String oldlastname = "";
            String oldtelephone = "";
            oldfirstname += request.getSession(false).getAttribute("firstname");
            oldlastname += request.getSession(false).getAttribute("lastname");
            oldtelephone += request.getSession(false).getAttribute("telephone");
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String telephone = request.getParameter("telephone");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
            Statement stmt = con.createStatement();

            int ID = employee.get_id(oldfirstname, oldlastname, oldtelephone);
            employee.updateEmployee(ID, firstname, lastname, telephone);

           
            request.getRequestDispatcher("index.jsp").forward(request, response);
            //con.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
