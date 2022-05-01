package com.example.patientlogin.doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long> {

    @Query("select u from Doctor u where u.username = ?1")
    Doctor findByUsername(String username);

    @Query("select u from Doctor u order by u.Id")
    List<Doctor> getAll();

}
