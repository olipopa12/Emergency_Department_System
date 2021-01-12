/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author kater
 */
public class ReExaminations {

    String createReExam() {
        String exam = "CREATE TABLE IF NOT EXISTS REEXAMINATIONS "
                + "(examID INTEGER not NULL, "
                + " docID INTEGER not NULL, "
                + " patientID INTEGER not NULL, "
                + " kindof VARCHAR(255), "
                + " diseaseID INTEGER not NULL, "
                + " medID INTEGER not NULL, "
                + " PRIMARY KEY ( examID ), "
                + " FOREIGN KEY(diseaseID) REFERENCES DISEASES(disID), "
                + " FOREIGN KEY(medID) REFERENCES MEDICINES(medID), "
                + " FOREIGN KEY(patientID) REFERENCES PATIENTS(patientID), "
                + " FOREIGN KEY(docID) REFERENCES DOCTORS(docID))";
        return exam;
    }
}
