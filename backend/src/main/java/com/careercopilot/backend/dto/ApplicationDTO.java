package com.careercopilot.backend.dto;

import com.careercopilot.backend.model.ApplicationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationDTO {
    
    private Long id;
    private String company;
    private String position;
    private ApplicationStatus status;
    private String jobUrl;
    private String jobDescription;
    private String notes;
    private String recruiterName;
    private String recruiterEmail;
    private String recruiterPhone;
    private LocalDateTime appliedDate;
    private LocalDateTime interviewDate;
    private String salary;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
