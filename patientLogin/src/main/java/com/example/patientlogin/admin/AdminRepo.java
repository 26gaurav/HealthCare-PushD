package com.example.patientlogin.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepo extends JpaRepository<Admin,Long> {

    @Query("select u from admin u where u.username = ?1")
    Admin findByUsername(String username);
}
