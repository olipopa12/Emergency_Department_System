/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.Doctors;
import java.io.IOException;
import database.Nurses;
import database.Employees;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kater
 */
public class see_date extends HttpServlet {

    private Doctors doc = new Doctors();
    private Employees emp = new Employees();
    private Nurses nur = new Nurses();

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String firstname = "";
            firstname += request.getSession(false).getAttribute("firstname");
            String lastname = "";
            lastname += request.getSession(false).getAttribute("lastname");
            String telephone = "";
            telephone += request.getSession(false).getAttribute("telephone");
            String start = request.getParameter("start");
            String end = request.getParameter("end");
            int IDdoc = doc.get_id(firstname, lastname, telephone);
            int IDemp = emp.get_id(firstname, lastname, telephone);
            int IDnur = nur.get_id(firstname, lastname, telephone);
            int ID = 0;
            if (IDdoc != -1) {
                ID = IDdoc;
            } else if (IDemp != -1) {
                ID = IDemp;
            } else {
                ID = IDnur;
            }

            HttpSession session = request.getSession(); //Creating a session
            //System.out.println(pat.get_id(firstname, lastname, telephone));
            session.setAttribute("id", ID);
            session.setAttribute("start", start);
            session.setAttribute("end", end);
            //System.out.println("id in doc: " + id);
            request.getRequestDispatcher("MyShifts.jsp").forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(see_date.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(see_date.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
