/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kater
 */
public class patient extends HttpServlet {

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String telephone = request.getParameter("telephone");
        String specialty = request.getParameter("specialty");
        System.out.println((String) firstname);
        System.out.println((String) lastname);
        System.out.println((String) telephone);
        System.out.println((String) specialty);*/
        request.getRequestDispatcher("patient.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String all = "";
        all += request.getSession(false).getAttribute("firstname");
        all += ",";
        all += request.getSession(false).getAttribute("lastname");
        all += ",";
        all += request.getSession(false).getAttribute("telephone");
        all += ",";
        all += request.getSession(false).getAttribute("insurance");
        all += ",";
        all += request.getSession(false).getAttribute("amka");
        all += ",";
        all += request.getSession(false).getAttribute("tk");
        all += ",";
        all += request.getSession(false).getAttribute("road");
        all += ",";
        all += request.getSession(false).getAttribute("number");
        String arr = URLEncoder.encode(all, "utf-8");
        response.getOutputStream().println(all); //finish
    }
}
