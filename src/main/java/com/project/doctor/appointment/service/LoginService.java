package com.project.doctor.appointment.service;

import com.project.doctor.appointment.dao.DoctorRepository;
import com.project.doctor.appointment.dao.PatientRepository;
import com.project.doctor.appointment.model.*;
import com.project.doctor.appointment.utils.BCryptUtils;
import com.project.doctor.appointment.utils.SessionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static com.project.doctor.appointment.utils.AppConstant.*;
import static com.project.doctor.appointment.utils.AppConstant.JSPFile.HOME_PAGE;

@Service
public class LoginService {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Autowired
    public LoginService(DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }


    public String homePage(Model model) {
        constructLoginDetails(model);
        return HOME_PAGE;
    }

    public String registerDoctor(RegisterUser registerUser, Model model, HttpServletRequest request) {
        if(!validateUserRegistration(registerUser, model)) {
            return  HOME_PAGE;
        }

        String password = registerUser.getPassword(); // plain english password
        String encodePassword = BCryptUtils.encodePassword(password); // encrypted password
        registerUser.setPassword(encodePassword);
        doctorRepository.save(constructDoctor(registerUser));

        LoginUser loginUser = new LoginUser(registerUser.getEmail(), password, DOCTOR);
        return loginUser(loginUser, model, request);
    }

    public String registerPatient(RegisterUser registerUser, Model model, HttpServletRequest request) {
        if(!validateUserRegistration(registerUser, model)) {
            return HOME_PAGE;
        }

        String password = registerUser.getPassword(); // plain english password
        String encodePassword = BCryptUtils.encodePassword(password); // encrypted password
        registerUser.setPassword(encodePassword);
        patientRepository.save(constructPatient(registerUser));

        LoginUser loginUser = new LoginUser(registerUser.getEmail(), password, PATIENT);
        return loginUser(loginUser, model, request);
    }

    public String loginUser(LoginUser loginUser, Model model, HttpServletRequest request) {
        User user;
        String type = loginUser.getType();
        if(type.equals(DOCTOR)){
            user = doctorRepository.findByEmail(loginUser.getEmail());
        } else {
            user = patientRepository.findByEmail(loginUser.getEmail());
        }

        if(user == null || !BCryptUtils.matchPassword(loginUser.getPassword(), user.getPassword())) {
            invalidLogin(model);
            return HOME_PAGE;
        }

        SessionUtils.setSession(request, user.getId(), type);

        return type.equals(DOCTOR)? REDIRECT_DOCTOR: REDIRECT_PATIENT;
    }

    public String logout(HttpServletRequest request) {
        SessionUtils.clearSession(request);
        return REDIRECT_HOME_PAGE;
    }

    private boolean validateUserRegistration(RegisterUser registerUser, Model model) {

        String userName = registerUser.getUserName();
        String email = registerUser.getEmail();
        String password = registerUser.getPassword();
        String confirmPassword = registerUser.getConfirmPassword();


        if(userName == null || userName.isBlank() || userName.length() < 3 || !StringUtils.isAlphaSpace(userName)) {
            updateUserRegistrationError(model, LoginError.USERNAME_ERROR);
            return false;
        }

        if(email == null || email.isBlank()) {
            updateUserRegistrationError(model, LoginError.INVALID_EMAIL);
            return false;
        }

        if(password == null || password.isBlank() || password.length() < 8) {
            updateUserRegistrationError(model, LoginError.PASSWORD_ERROR);
            return false;
        }

        if(!password.equals(confirmPassword)) {
            updateUserRegistrationError(model, LoginError.PASSWORD_MISS_MATCH);
            return false;
        }

        return true;
    }

    private void updateUserRegistrationError(Model model, String error) {
        Map<String, Object> objectMap = model.asMap();
        objectMap.put(REGISTER_ERROR, error);
        objectMap.put(LOGIN_USER, new LoginUser());
    }

    private void invalidLogin(Model model) {
        Map<String, Object> objectMap = model.asMap();
        objectMap.put(USER_LOGIN_ERROR, LoginError.INVALID_LOGIN);
        constructLoginDetails(model);
    }

    private Doctor constructDoctor(RegisterUser registerUser) {
        return new Doctor(registerUser.getUserName(), registerUser.getEmail(), registerUser.getPassword());
    }

    private Patient constructPatient(RegisterUser registerUser) {
        return new Patient(registerUser.getUserName(), registerUser.getEmail(), registerUser.getPassword());
    }

    private void constructLoginDetails(Model model) {
        Map<String, Object> objectMap = model.asMap();
        objectMap.put(REGISTER_USER, new RegisterUser());
        objectMap.put(LOGIN_USER, new LoginUser());
    }
}
