/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.Nurses;
import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kater
 */
public class get_nurses extends HttpServlet {

    private Nurses nurses = new Nurses();

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
        try {
            all += nurses.get_Nurses();
            String arr = URLEncoder.encode(all, "utf-8");
            //System.out.println(all);
        } catch (Exception ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }
        response.getOutputStream().println(all); //finish

    }
}
