package com.example.prdportal.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "prds")
public class Prd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String pid;
    private String title;
    private String status; // Accepted, Rejected, Pending
    private String author;
    private String clientName;
    private String version;
    private LocalDateTime lastModified;
    
    @Column(columnDefinition = "TEXT")
    private String overview;
    
    @Column(columnDefinition = "TEXT")
    private String functionalRequirements;
}
