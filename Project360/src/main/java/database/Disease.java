package database;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author olipo
 */
public class Disease {
 String createDoctor() {
        String doc = "CREATE TABLE IF NOT EXISTS DOCTORS "
                + "(docID INTEGER not NULL, "
                + " name VARCHAR(255), "
                + " specialty VARCHAR(255), "
                + " phone VARCHAR(255), "
                + " PRIMARY KEY ( docID ));";
        return doc;
    }
}
