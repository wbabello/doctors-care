package com.project.doctor.appointment.model;

import javax.persistence.Entity;

@Entity
public class Patient extends User {

    public Patient() {
    }

    public Patient(String userName, String email, String password) {
        super(userName, email, password);
    }
}
