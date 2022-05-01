package com.example.doctorbackend.repo;

import com.example.doctorbackend.model.Patient;
import com.example.doctorbackend.model.Patient_progress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public interface PatientProgressRepository extends JpaRepository<Patient_progress, Long> {

    List<Patient_progress> findByPatient(Patient patient);

    @Transactional
    @Modifying
    @Query("DELETE FROM Patient_progress WHERE patient = ?1")
    void deleteByPatientId(Patient patient);

//    @Query("delete from CLimit l where l.trader.id =:#{#trader.id}")
//    void deleteLimitsByTrader(@Param("trader") CTrader trader);
}
