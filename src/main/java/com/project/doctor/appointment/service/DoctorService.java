package com.project.doctor.appointment.service;

import com.project.doctor.appointment.dao.AddAvailabilityRepository;
import com.project.doctor.appointment.dao.DoctorRepository;
import com.project.doctor.appointment.model.AddAvailability;
import com.project.doctor.appointment.model.Doctor;
import com.project.doctor.appointment.model.Slot;
import com.project.doctor.appointment.utils.DateFormatUtils;
import com.project.doctor.appointment.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.project.doctor.appointment.utils.AppConstant.*;
import static com.project.doctor.appointment.utils.AppConstant.JSPFile.*;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final AddAvailabilityRepository addAvailabilityRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository, AddAvailabilityRepository addAvailabilityRepository) {
        this.doctorRepository = doctorRepository;
        this.addAvailabilityRepository = addAvailabilityRepository;
    }

    public String doctorDashboard(Model model, HttpServletRequest request) {
        if(isInValidSession(request))
            return HOME_PAGE;

        Doctor doctor = fetchUserFromSession(request);
        Map<String, Object> objectMap = model.asMap();
        objectMap.put(DOCTOR_OBJ, doctor);
        objectMap.put(CURRENT_DATE, DateFormatUtils.formatDate(Instant.now().toEpochMilli()));

        //List of Slot
        List<Slot> morningSlot = new ArrayList<>();
        List<Slot> afternoonSlot = new ArrayList<>();
        List<Slot> eveningSlot = new ArrayList<>();
        List<AddAvailability> availabilityList = addAvailabilityRepository.findByDoctor(doctor);
        availabilityList.forEach(availability -> {
            if(availability.getPeriod().equals("Morning")) {
                morningSlot.add(new Slot(availability.getId(), availability.getTime()));
            } else if(availability.getPeriod().equals("Afternoon")) {
                afternoonSlot.add(new Slot(availability.getId(), availability.getTime()));
            } else {
                eveningSlot.add(new Slot(availability.getId(), availability.getTime()));
            }

        });
        objectMap.put(MORNING_AVAILABILITY, morningSlot);
        objectMap.put(AFTERNOON_AVAILABILITY, afternoonSlot);
        objectMap.put(EVENING_AVAILABILITY, eveningSlot);
        return DOCTOR_DASHBOARD;
    }

    public String doctorAddAvailabilityDashboard(Model model, HttpServletRequest request) {
        if(isInValidSession(request))
            return HOME_PAGE;

        Doctor doctor = fetchUserFromSession(request);
        Map<String, Object> objectMap = model.asMap();
        objectMap.put(DOCTOR_OBJ, doctor);
        objectMap.put(ADD_AVAILABILITY, new AddAvailability());

        return DOCTOR_ADD_AVAILABILITY;
    }

    public String addAvailability(AddAvailability addAvailability, Model model, HttpServletRequest request) {
        if(isInValidSession(request))
            return HOME_PAGE;

        Doctor doctor = fetchUserFromSession(request);
        addAvailability.setDoctor(doctor);
        addAvailabilityRepository.save(addAvailability);
        return REDIRECT_DOCTOR;
    }

    private boolean isInValidSession(HttpServletRequest request) {
        Integer userId = SessionUtils.getCurrentUserId(request);
        String type = SessionUtils.getCurrentUserType(request);
        return userId == null && !DOCTOR.equals(type);
    }

    private Doctor fetchUserFromSession(HttpServletRequest request) {
        Integer userId = SessionUtils.getCurrentUserId(request);
        return doctorRepository.findById(userId).get();
    }
}
