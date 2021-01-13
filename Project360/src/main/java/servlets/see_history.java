/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.Patients;
import java.io.IOException;
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
public class see_history extends HttpServlet {

    private Patients pat = new Patients();

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
            //System.out.println(id);
            HttpSession session = request.getSession(); //Creating a session
            //System.out.println(pat.get_id(firstname, lastname, telephone));
            session.setAttribute("id", pat.get_id(firstname, lastname, telephone));
            request.getRequestDispatcher("history_of_patient.jsp").forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(see_history.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(see_history.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
