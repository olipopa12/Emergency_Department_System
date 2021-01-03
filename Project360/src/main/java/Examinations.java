/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author olipo
 */
public class Examinations {
    String createExam() {
        String exam = "CREATE TABLE IF NOT EXISTS EXAMINATIONS "
                + "(examID INTEGER not NULL, "
                + " docID INTEGER not NULL, "
                + " kindof VARCHAR(255), "
                + " PRIMARY KEY ( examID ), "
                + " FOREIGN KEY(docID) REFERENCES DOCTORS(docID))";
        return exam;
    }
}
