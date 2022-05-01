package com.example.doctorbackend.repo;

import com.example.doctorbackend.model.MessageSpecialist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageSpecialistRepo extends JpaRepository<MessageSpecialist,Long> {

    @Query("select u from MessageSpecialist u where u.doctor.Id = ?1")
    List<MessageSpecialist> getAllByDoctorId(Long doc_id);

    @Query("select u from MessageSpecialist u where u.doctor.Id = ?1 and u.postedBy=true and u.readReceipt=false")
    List<MessageSpecialist> getAllBySpecialistIdAndSentBySpecialist(Long doc_id);

    @Query("select u from MessageSpecialist u where u.doctor.Id = ?1 and u.postedBy=false and u.readReceipt=false")
    List<MessageSpecialist> getAllBySpecialistIdAndNotSentBySpecialist(Long doc_id);

    @Query("select u from MessageSpecialist u where u.doctor.Id = ?1 and u.specialist.Id = ?2")
    List<MessageSpecialist> getAllMessages(Long doc_id, Long spec_id);


//    @Query("select u from MessageSpecialist u where u.doctor.Id = ?1")
//    List<MessageSpecialist> getAllBySpecialistId(Long spec_id);
}
