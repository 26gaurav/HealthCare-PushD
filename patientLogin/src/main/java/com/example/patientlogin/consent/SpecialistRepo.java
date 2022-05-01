package com.example.patientlogin.consent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpecialistRepo extends JpaRepository<Specialist,Long> {
    @Query("select u from Specialist u order by u.Id")
    List<Specialist> getAll();

    @Query("select u from Specialist u where u.email = ?1")
    Specialist findByEmail(String email);
}
