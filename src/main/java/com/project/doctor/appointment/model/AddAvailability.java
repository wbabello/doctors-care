package com.project.doctor.appointment.model;

import javax.persistence.*;

@Entity
public class AddAvailability {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "time")
    private String time;

    @Column(name = "period")
    private String period;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    public AddAvailability() {
    }

    public AddAvailability(String time, String period) {
        this.time = time;
        this.period = period;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
