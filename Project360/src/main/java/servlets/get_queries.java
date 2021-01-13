/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.Patients;
import database.PatientsInShift;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kater
 */
public class get_queries extends HttpServlet {

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
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
            //stmt = con.createStatement();
            String all = "";
            String queries = request.getParameter("queries");
            String[] q = queries.split(" ");
            String kati = "";
            PreparedStatement ps = con.prepareStatement(queries);
            if (q[0].equals("SELECT") || q[0].equals("select")) {

                ResultSet rs = ps.executeQuery();
                ResultSetMetaData rsmd = rs.getMetaData();
                int cols = rsmd.getColumnCount();
                for (int i = 1; i <= cols; i++) {
                    if (kati == null) {
                        kati = rsmd.getColumnName(i);
                    } else {

                        kati += " ";
                        kati += rsmd.getColumnName(i);
                    }

                }
                kati += "\n";
                while (rs.next()) {
                    for (int i = 1; i <= cols; i++) {
                        String type = rsmd.getColumnTypeName(i);

                        if (kati == null) {
                            if (type.equals("INT")) {
                                kati = String.valueOf(rs.getInt(rsmd.getColumnName(i)));
                            } else {
                                kati = rs.getString(rsmd.getColumnName(i));
                            }
                        } else {
                            if (type.equals("INT")) {
                                kati += " ";
                                kati += String.valueOf(rs.getInt(rsmd.getColumnName(i)));
                            } else {
                                kati += " ";
                                kati += rs.getString(rsmd.getColumnName(i));
                            }
                        }
                    }
                    kati += "\n";
                }
            } else {
                Statement stmt = con.createStatement();
                stmt.executeUpdate(queries);
                kati += "\n";
                kati += "\n";
                kati += "\n";
                kati += "CHECK YOUR DATABASE TO SEE THE CHANGES";
                kati += "\n";
            }
            try {
                all += kati;
                String arr = URLEncoder.encode(all, "utf-8");
                //System.out.println(all);
            } catch (Exception ex) {
                System.out.println(ex);
                ex.printStackTrace();
            }
            con.close();
            //System.out.println(all);
            response.getOutputStream().println(all); //finish
            /*System.out.println(queries);
            PreparedStatement pstmt = con.prepareStatement(queries);
            ResultSet rs = pstmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            String all = "";

            System.out.println("Total columns: " + rsmd.getColumnCount());
            System.out.println("Column Name of 1st column: " + rsmd.getColumnName(1));
            System.out.println("Column Type Name of 1st column: " + rsmd.getColumnTypeName(1));

             */
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
