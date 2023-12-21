package com.psi.fhir.myapplication.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Patient implements Serializable {

    //declare private data instead of public to ensure the privacy of data field of each class
    private String name;
    private String hometown;

    public Patient(String name, String hometown) {
        this.name = name;
        this.hometown = hometown;
    }

    //retrieve user's name
    public String getName(){
        return name;
    }

    //retrieve users' hometown
    public String getHometown(){
        return hometown;
    }

    public static ArrayList<Patient> getUsers() {
        ArrayList<Patient> users = new ArrayList<Patient>();
        users.add(new Patient("Harry", "San Diego"));
        users.add(new Patient("Marla", "San Francisco"));
        users.add(new Patient("Sarah", "San Marco"));
        return users;
    }
}