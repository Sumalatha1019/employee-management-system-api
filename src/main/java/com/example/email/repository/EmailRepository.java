package com.example.email.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.email.model.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {

    public EmailRepository emailRepository;



}
