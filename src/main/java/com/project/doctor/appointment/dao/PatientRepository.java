package com.project.doctor.appointment.dao;

import com.project.doctor.appointment.model.Patient;
import com.project.doctor.appointment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    @Query("from Patient where email = ?1")
    User findByEmail(String email);
}
