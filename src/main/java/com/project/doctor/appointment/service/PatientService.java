package com.project.doctor.appointment.service;

import com.project.doctor.appointment.dao.AddAvailabilityRepository;
import com.project.doctor.appointment.dao.AppointmentRepository;
import com.project.doctor.appointment.dao.PatientRepository;
import com.project.doctor.appointment.model.AddAvailability;
import com.project.doctor.appointment.model.Appointment;
import com.project.doctor.appointment.model.AppointmentDTO;
import com.project.doctor.appointment.model.Patient;
import com.project.doctor.appointment.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.List;
import java.util.Map;

import static com.project.doctor.appointment.utils.AppConstant.*;
import static com.project.doctor.appointment.utils.AppConstant.JSPFile.*;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final AppointmentRepository appointmentRepository;

    private final AddAvailabilityRepository addAvailabilityRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository, AppointmentRepository appointmentRepository, AddAvailabilityRepository addAvailabilityRepository) {
        this.patientRepository = patientRepository;
        this.appointmentRepository = appointmentRepository;
        this.addAvailabilityRepository = addAvailabilityRepository;
    }


    public String patientDashboard(Model model, HttpServletRequest request) {
        if(isInValidSession(request))
            return HOME_PAGE;

        Patient patient = fetchUserFromSession(request);
        List<AppointmentDTO> appointments = AppointmentDTO.contruct(appointmentRepository.findByPatient(patient));
        Map<String, Object> objectMap = model.asMap();
        objectMap.put(PATIENT_OBJ, patient);
        objectMap.put(APPOINTMENT_LIST, appointments);
        return PATIENT_DASHBOARD;
    }

    public String bookAppointmentDashboard(Model model, HttpServletRequest request) {
        if(isInValidSession(request))
            return HOME_PAGE;

        Patient patient = fetchUserFromSession(request);
        Map<String, Object> objectMap = model.asMap();
        List<AddAvailability> addAvailabilities = addAvailabilityRepository.findAll();
        List<String> doctorNames = addAvailabilities.stream().map(it -> it.getDoctor().getUserName()).distinct().toList();
        objectMap.put(PATIENT_OBJ, patient);
        objectMap.put(APPOINTMENT, new Appointment());
        objectMap.put(ADD_AVAILABILITIES_LIST, addAvailabilities);
        objectMap.put(DOCTOR_LIST, doctorNames);
        return PATIENT_BOOK_APPOINTMENT;
    }

    public String bookAppointment(Appointment appointment, Model model, HttpServletRequest request) {
        if(isInValidSession(request))
            return HOME_PAGE;
        Patient patient = fetchUserFromSession(request);
        appointment.setPatient(patient);
        appointment.setCreateAt(Instant.now().toEpochMilli());
        appointmentRepository.save(appointment);
        return REDIRECT_PATIENT;
    }

    private boolean isInValidSession(HttpServletRequest request) {
        Integer userId = SessionUtils.getCurrentUserId(request);
        String type = SessionUtils.getCurrentUserType(request);
        return userId == null && !PATIENT.equals(type);
    }

    private Patient fetchUserFromSession(HttpServletRequest request) {
        Integer userId = SessionUtils.getCurrentUserId(request);
        return patientRepository.findById(userId).get();
    }
}
