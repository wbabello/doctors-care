package com.project.doctor.appointment.model;

public class Slot {
    private Integer id;
    private String value;

    public Slot() {
    }

    public Slot(Integer id, String value) {
        this.id = id;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
