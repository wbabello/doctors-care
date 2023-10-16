package com.project.doctor.appointment.controller;

import com.project.doctor.appointment.model.AddAvailability;
import com.project.doctor.appointment.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

import static com.project.doctor.appointment.utils.AppConstant.ADD_AVAILABILITY;

@Controller
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/doctor/availability")
    public String doctorDashboard(Model model, HttpServletRequest request) {
        return doctorService.doctorDashboard(model, request);
    }

    @GetMapping("/doctor/availability/new")
    public String doctorAddAvailabilityDashboard(Model model, HttpServletRequest request) {
        return doctorService.doctorAddAvailabilityDashboard(model, request);
    }

    @PostMapping("/doctor/availability/new")
    public String addAvailability(@ModelAttribute(ADD_AVAILABILITY) AddAvailability addAvailability, Model model, HttpServletRequest request) {
        return doctorService.addAvailability(addAvailability, model, request);
    }

    @GetMapping("/doctor/availability/{id}")
    public String updateAvailabilityDashboard(@PathVariable("id") Integer id, Model model, HttpServletRequest request) {
        return doctorService.updateAvailabilityDashboard(id, model, request);
    }

    @PostMapping("/doctor/availability/{id}")
    public String updateAvailability(@PathVariable("id") Integer id, @ModelAttribute(ADD_AVAILABILITY) AddAvailability addAvailability, Model model, HttpServletRequest request) {
        return doctorService.updateAvailability(id, addAvailability, model, request);
    }

    @GetMapping("/doctor/availability/{id}/delete")
    public String deleteAvailability(@PathVariable("id") Integer id, Model model, HttpServletRequest request) {
        return doctorService.deleteAvailability(id, model, request);
    }


}
