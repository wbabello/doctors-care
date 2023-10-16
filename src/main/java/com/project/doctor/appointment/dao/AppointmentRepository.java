package com.project.doctor.appointment.dao;

import com.project.doctor.appointment.model.Appointment;
import com.project.doctor.appointment.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    List<Appointment> findByPatient(Patient patient);
}
