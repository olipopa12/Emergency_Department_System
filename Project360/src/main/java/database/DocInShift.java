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
public class DocInShift {

    String createDocsInShift() {
        String sql = "CREATE TABLE IF NOT EXISTS DOCS_IN_SHIFT "
                + "(docID INTEGER not NULL, "
                + " shiftID INTEGER not NULL, "
                + " FOREIGN KEY(shiftID) REFERENCES SHIFTS(shiftID), "
                + " FOREIGN KEY(docID) REFERENCES DOCTORS(docID));";
        return sql;
    }
}
