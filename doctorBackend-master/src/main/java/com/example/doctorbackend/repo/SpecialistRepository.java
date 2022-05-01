package com.example.doctorbackend.repo;

import com.example.doctorbackend.model.Specialist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecialistRepository extends JpaRepository<Specialist, Long> {

    List<Specialist> getSpecialistByEmail(String email);
}
