package com.example.patientlogin.messages;

import com.example.patientlogin.appuser.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface MessageRepo extends JpaRepository<Messages,Long> {

    @Transactional
    @Query("select u from messages u where u.appUser.Id = ?1")
    List<Messages> getAllByPatientId(Long pat_id);

    @Query("select u from messages u where u.appUser.Id = ?1 and u.postedBy=false and u.readReceipt=false")
    List<Messages> getAllByPatientIdAndNotSentByPatient(Long pat_id);

    List<Messages> getMessagesByAppUser(AppUser appUser);

//    @Override
//    List<Messages> findAllById(Iterable<Long> ids);
}
