/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.Doctor;
import database.Employees;
import database.LoginInfo;
import database.Nurses;
import database.Patients;
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

    private LoginInfo info = new LoginInfo();
    private Doctor doctor = new Doctor();
    private Nurses nurse = new Nurses();
    private Employees employee = new Employees();
    private Patients patient = new Patients();

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {

            // read form fields
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            System.out.println("password: " + password);
            System.out.println("name: " + username);
            //String ret = info.check_role(username, password);
            String role = null;
            int ID = -1;
            role = info.get_role(username, password);
            if (role != null) {
                ID = info.get_id(username, password);

                String telephone = null;
                String name = null;
                String address = null;
                String amka = null;
                String insurance = null;
                String specialty = null;

                System.out.println(role + " " + ID);

                // System.out.println("password: " + password);
                 HttpSession session = request.getSession(); //Creating a session
                if (role.equals("patient")) {
                    session.setAttribute("name", patient.get_name(ID));
                    session.setAttribute("address", patient.get_address(ID));
                    session.setAttribute("amka", patient.get_amka(ID));
                    session.setAttribute("insurance", patient.get_insurance(ID));
                    session.setAttribute("telephone", patient.get_telephone(ID));
                    response.sendRedirect(request.getContextPath() + "/patient");
                } else if (role.equals("doctor")) {
                    session.setAttribute("specialty", doctor.get_specialty(ID));
                    session.setAttribute("name", doctor.get_name(ID));
                    session.setAttribute("telephone", doctor.get_telephone(ID));
                    response.sendRedirect(request.getContextPath() + "/doctor");
                } else if (role.equals("nurse")) {
                    session.setAttribute("name", nurse.get_name(ID));
                    session.setAttribute("telephone", nurse.get_telephone(ID));
                    response.sendRedirect(request.getContextPath() + "/nurse");
                } else if (role.equals("employee")) {
                    session.setAttribute("name", employee.get_name(ID));
                    session.setAttribute("telephone", employee.get_telephone(ID));
                    response.sendRedirect(request.getContextPath() + "/employee");
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/errorUser");
            }
            //request.getRequestDispatcher("login.jsp").forward(request, response);
            //con.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

}
