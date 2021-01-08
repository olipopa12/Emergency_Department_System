/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.Doctors;
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
    private Doctors doctor = new Doctors();
    private Nurses nurse = new Nurses();
    private Employees employee = new Employees();
    private Patients patient = new Patients();

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {

            // read form fields
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            if (username.equals(" ") || password.equals(" ")) {
                response.sendRedirect(request.getContextPath() + "/errorUser");
            }
            String role = null;
            String telephone = null;
            String firstname = null;
            String lastname = null;
            String road = null;
            int number = -1;
            int tk = -1;
            String amka = null;
            String insurance = null;
            String specialty = null;
            int ID = -1;
            role = info.get_role(username, password);
            
            if (role != null) {
                ID = info.get_id(username, password);

               //System.out.println(role + " " + ID);

                // System.out.println("password: " + password);
                HttpSession session = request.getSession(); //Creating a session

                if (role.equals("patient")) {
                    session.setAttribute("firstname", patient.get_firstname(ID));
                    session.setAttribute("lastname", patient.get_lastname(ID));
                    session.setAttribute("road", patient.get_road(ID));
                    session.setAttribute("number", patient.get_number(ID));
                    session.setAttribute("tk", patient.get_tk(ID));
                    session.setAttribute("amka", patient.get_amka(ID));
                    session.setAttribute("insurance", patient.get_insurance(ID));
                    session.setAttribute("telephone", patient.get_telephone(ID));
                    response.sendRedirect(request.getContextPath() + "/patient");
                } else if (role.equals("doctor")) {
                    session.setAttribute("specialty", doctor.get_specialty(ID));
                    session.setAttribute("firstname", doctor.get_firstname(ID));
                    session.setAttribute("lastname", doctor.get_lastname(ID));
                    session.setAttribute("telephone", doctor.get_telephone(ID));
                    response.sendRedirect(request.getContextPath() + "/doctor");
                } else if (role.equals("nurse")) {
                    session.setAttribute("firstname", nurse.get_firstname(ID));
                    session.setAttribute("lastname", nurse.get_lastname(ID));
                    session.setAttribute("telephone", nurse.get_telephone(ID));
                    response.sendRedirect(request.getContextPath() + "/nurse");
                } else if (role.equals("employee")) {
                    session.setAttribute("firstname", employee.get_firstname(ID));
                    session.setAttribute("lastname", employee.get_lastname(ID));
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
