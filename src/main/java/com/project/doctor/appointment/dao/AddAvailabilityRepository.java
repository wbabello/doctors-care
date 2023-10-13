package com.project.doctor.appointment.dao;

import com.project.doctor.appointment.model.AddAvailability;
import com.project.doctor.appointment.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddAvailabilityRepository extends JpaRepository<AddAvailability, Integer> {

    List<AddAvailability> findByDoctor(Doctor doctor);
}
