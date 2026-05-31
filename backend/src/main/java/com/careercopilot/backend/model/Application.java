package com.careercopilot.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "applications")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Application {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String company;
    
    @Column(nullable = false)
    private String position;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ApplicationStatus status;
    
    @Column(name = "job_url")
    private String jobUrl;
    
    @Column(columnDefinition = "TEXT")
    private String jobDescription;
    
    @Column(columnDefinition = "TEXT")
    private String notes;
    
    @Column(name = "recruiter_name")
    private String recruiterName;
    
    @Column(name = "recruiter_email")
    private String recruiterEmail;
    
    @Column(name = "recruiter_phone")
    private String recruiterPhone;
    
    @Column(name = "applied_date")
    private LocalDateTime appliedDate;
    
    @Column(name = "interview_date")
    private LocalDateTime interviewDate;
    
    @Column(name = "salary")
    private String salary;
    
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @Column(name = "user_id")
    private Long userId;
}
