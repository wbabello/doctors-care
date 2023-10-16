package com.project.doctor.appointment.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Doctor extends User {

    @OneToMany(targetEntity = AddAvailability.class, mappedBy = "doctor")
    private List<AddAvailability> addAvailabilities;

    public Doctor() {
    }

    public Doctor(String userName, String email, String password) {
        super(userName, email, password);
    }

    public List<AddAvailability> getAddAvailabilities() {
        return addAvailabilities;
    }

    public void setAddAvailabilities(List<AddAvailability> addAvailabilities) {
        this.addAvailabilities = addAvailabilities;
    }
}
