package com.project.doctor.appointment.controller;

import com.project.doctor.appointment.model.Appointment;
import com.project.doctor.appointment.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

import static com.project.doctor.appointment.utils.AppConstant.APPOINTMENT;

@Controller
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patient/view")
    public String patientDashboard(Model model, HttpServletRequest request) {
        return patientService.patientDashboard(model, request);
    }

    @GetMapping("/patient/book-appointment")
    public String bookAppointmentDashboard(Model model, HttpServletRequest request) {
        return patientService.bookAppointmentDashboard(model, request);
    }

    @PostMapping("/patient/book-appointment")
    public String bookAppointment(@ModelAttribute(APPOINTMENT) Appointment appointment, Model model, HttpServletRequest request) {
        return patientService.bookAppointment(appointment, model, request);
    }
}
