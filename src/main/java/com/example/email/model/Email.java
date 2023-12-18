package com.example.email.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
//@Table(name="email")
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subject;
    private String body;
    private String toAddress;

    @Transient
    private String filepath;

}
