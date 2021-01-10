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
public class ExamFromNurse {
    String createExamFromNurse() {
        String exam = "CREATE TABLE IF NOT EXISTS EXAMINATIONS_FROM_NURSES "
                + "(examID INTEGER not NULL, "
                + " nurseID INTEGER not NULL, "
                 + " patientID INTEGER not NULL, "
                + " docID INTEGER not NULL, "
                + " kindof VARCHAR(255), "
                + " PRIMARY KEY ( examID ), "
                + " FOREIGN KEY(docID) REFERENCES DOCTORS(docID), "
                + " FOREIGN KEY(patientID) REFERENCES PATIENTS(patientID), "
                + " FOREIGN KEY(nurseID) REFERENCES NURSES(nurseID))";
        return exam;
    }
}
