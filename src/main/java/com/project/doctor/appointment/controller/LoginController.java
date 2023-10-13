package com.project.doctor.appointment.controller;

import com.project.doctor.appointment.model.LoginUser;
import com.project.doctor.appointment.model.RegisterUser;
import com.project.doctor.appointment.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }


    @GetMapping("/")
    public String homePage(Model model) {
        return loginService.homePage(model);
    }

    @PostMapping("/doctor/register")
    public String registerDoctor(@ModelAttribute("registerUser")RegisterUser registerUser, Model model, HttpServletRequest request) {
        return loginService.registerDoctor(registerUser, model, request);
    }

    @PostMapping("/patient/register")
    public String registerPatient(@ModelAttribute("registerUser")RegisterUser registerUser, Model model, HttpServletRequest request) {
        return loginService.registerPatient(registerUser, model, request);
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute("loginUser") LoginUser loginUser, Model model, HttpServletRequest request) {
        return loginService.loginUser(loginUser, model, request);
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        return loginService.logout(request);
    }
}
