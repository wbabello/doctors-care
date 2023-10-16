package com.project.doctor.appointment.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Patient extends User {

    @OneToMany(targetEntity = Appointment.class, mappedBy = "patient")
    private List<Appointment> appointments;

    public Patient() {
    }

    public Patient(String userName, String email, String password) {
        super(userName, email, password);
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
