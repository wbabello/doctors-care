package com.project.doctor.appointment.dao;

import com.project.doctor.appointment.model.Doctor;
import com.project.doctor.appointment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    @Query("from Doctor where email = ?1")
    User findByEmail(String email);
}
