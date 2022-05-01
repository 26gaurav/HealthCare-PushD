package com.example.doctorbackend.repo;

import com.example.doctorbackend.model.Messages;
import com.example.doctorbackend.model.Doctor;
import com.example.doctorbackend.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface MessageRepo extends JpaRepository<Messages,Long> {

    @Transactional
    @Query("select u from messages u where u.patient.Id = ?1")
    List<Messages> getAllByPatientId(Long pat_id);

//    @Query("select distinct u.patient, u.id from messages u where u.doctor.Id = ?1 order by u.id desc")
//    List<Patient> getAllDistinctByDoctorIdDesc(Long doc_id);

    List<Messages> getMessagesByDoctor(Doctor doctor);
    List<Messages> getMessagesByDoctorAndPatient(Doctor doctor, Patient patient);

    @Query("select u from messages u where u.patient.Id = ?1 and u.postedBy=true and u.readReceipt=false")
    List<Messages> getAllByPatientIdAndSentByPatient(Long pat_id);
}
