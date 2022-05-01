package com.example.patientlogin.patient_progress;

import com.example.patientlogin.appuser.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PatientProgressRepo extends JpaRepository<PatientProgress, Long> {
//    void save(Long pat_id, Long sec_id);

    @Transactional
    @Modifying
    @Query("DELETE FROM PatientProgress WHERE appUser = ?1")
    void deleteByPatientId(AppUser patient);
}
