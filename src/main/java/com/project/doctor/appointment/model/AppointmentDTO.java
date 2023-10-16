package com.project.doctor.appointment.model;

import com.project.doctor.appointment.utils.DateFormatUtils;

import java.util.List;

public class AppointmentDTO {


    private Integer id;
    private String doctorName;

    private String timeSlot;

    private String comment;

    private String createAt;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public static AppointmentDTO contruct(Appointment appointment) {
        AppointmentDTO appointmentDTO = new AppointmentDTO();
        appointmentDTO.setId(appointment.getId());
        appointmentDTO.setDoctorName(appointment.getDoctorName());
        appointmentDTO.setComment(appointment.getComment());
        appointmentDTO.setTimeSlot(appointment.getTimeSlot());
        appointmentDTO.setCreateAt(DateFormatUtils.formatDate(appointment.getCreateAt()));
        return appointmentDTO;
    }

    public static List<AppointmentDTO> contruct(List<Appointment> appointments) {
        return appointments.stream().map(AppointmentDTO::contruct).toList();
    }
}
