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
public class NursesInShift {
     String createNursesInShift() {
        String sql = "CREATE TABLE IF NOT EXISTS NURSES_IN_SHIFT "
                + "(nurseID INTEGER not NULL, "
                + " shiftID INTEGER not NULL, "
                + " FOREIGN KEY(shiftID) REFERENCES SHIFTS(shiftID), "
                + " FOREIGN KEY(nurseID) REFERENCES NURSES(nurseID));";
        return sql;
    }
}
