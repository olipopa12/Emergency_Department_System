/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author olipo
 */
public class EmployeesInShift {

    String createEmployeesInShift() {
        String sql = "CREATE TABLE IF NOT EXISTS EMPLOYEES_IN_SHIFT "
                + "(employeeID INTEGER not NULL, "
                + " shiftID INTEGER not NULL, "
                + " FOREIGN KEY(shiftID) REFERENCES SHIFTS(shiftID), "
                + " FOREIGN KEY(employeeID) REFERENCES EMPLOYEES(employeeID));";
        return sql;
    }

    public void insertEmployeeInShift(int eid, int sid) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String empInShift = "INSERT IGNORE INTO EMPLOYEES_IN_SHIFT VALUES (?,?)";
        PreparedStatement pstmt = con.prepareStatement(empInShift);
        try {

            pstmt.setInt(1, eid);
            pstmt.setInt(2, sid);
            pstmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeesInShift.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String get_EmpInShift() throws ClassNotFoundException, SQLException {
        //String id = "SELECT role FROM LOGIN_INFOS WHERE username=\"kate\" AND password=\"kate1234\"";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String emp = "SELECT ES.employeeID,E.firstname,E.lastname,ES.shiftID FROM EMPLOYEES E,EMPLOYEES_IN_SHIFT ES,SHIFTS S "
                + "WHERE E.employeeID=ES.employeeID AND ES.shiftID=S.shiftID AND S.date=?;";
        PreparedStatement pstmt = con.prepareStatement(emp);
        int eid = 0;
        int sid = 0;

        String first = null;
        String last = null;
        String emps = null;
        String allEmp = null;
        // ResultSet rs=null;
        try {
pstmt.setString(1, String.valueOf(java.time.LocalDate.now()));
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                eid = rs.getInt("employeeID");
                sid = rs.getInt("shiftID");
                first = rs.getString("firstname");
                last = rs.getString("lastname");
                emps = (String.valueOf(eid) + " " + first + " " + last + " " + String.valueOf(sid) + ",");
                if (allEmp == null) {
                    allEmp = emps;
                } else {
                    allEmp = allEmp + emps;
                }
                //phone = rs.getString("phone");
                //System.out.println(id + " " + symp);
            }
            // System.out.println(r);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeesInShift.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allEmp;
    }
    public String get_EmpShifts(int id,String date1,String date2) throws ClassNotFoundException, SQLException {
        //String id = "SELECT role FROM LOGIN_INFOS WHERE username=\"kate\" AND password=\"kate1234\"";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String shifts = "SELECT S.date FROM EMPLOYEES_IN_SHIFT ES,SHIFTS S "
                + "WHERE S.shiftID=ES.shiftID AND ES.employeeID=? AND S.date between ? AND ?;";
        PreparedStatement pstmt = con.prepareStatement(shifts);
        //int did = 0;
        //int sid = 0;

        String date = null;
        String allShifts = null;
        // ResultSet rs=null;
        try {
pstmt.setInt(1, id);
pstmt.setString(2, date1);
pstmt.setString(3, date2);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                date = rs.getString("date");
                if (allShifts == null) {
                    allShifts = date+",";
                } else {
                    allShifts = allShifts + date+",";
                }
            }
            // System.out.println(r);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeesInShift.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allShifts;
    }
}
