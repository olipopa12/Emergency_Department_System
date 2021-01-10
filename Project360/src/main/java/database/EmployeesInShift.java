/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

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
}
