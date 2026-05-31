package com.careercopilot.backend.service;

import com.careercopilot.backend.dto.ApplicationDTO;
import com.careercopilot.backend.model.Application;
import com.careercopilot.backend.model.ApplicationStatus;
import com.careercopilot.backend.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicationService {
    
    private final ApplicationRepository applicationRepository;
    
    public ApplicationDTO createApplication(ApplicationDTO dto, Long userId) {
        Application application = new Application();
        application.setCompany(dto.getCompany());
        application.setPosition(dto.getPosition());
        application.setStatus(dto.getStatus() != null ? dto.getStatus() : ApplicationStatus.APPLIED);
        application.setJobUrl(dto.getJobUrl());
        application.setJobDescription(dto.getJobDescription());
        application.setNotes(dto.getNotes());
        application.setRecruiterName(dto.getRecruiterName());
        application.setRecruiterEmail(dto.getRecruiterEmail());
        application.setRecruiterPhone(dto.getRecruiterPhone());
        application.setAppliedDate(dto.getAppliedDate() != null ? dto.getAppliedDate() : LocalDateTime.now());
        application.setInterviewDate(dto.getInterviewDate());
        application.setSalary(dto.getSalary());
        application.setUserId(userId);
        
        Application saved = applicationRepository.save(application);
        return convertToDTO(saved);
    }
    
    public ApplicationDTO updateApplication(Long id, ApplicationDTO dto, Long userId) {
        Application application = applicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found"));
        
        if (!application.getUserId().equals(userId)) {
            throw new RuntimeException("Unauthorized access to this application");
        }
        
        application.setCompany(dto.getCompany());
        application.setPosition(dto.getPosition());
        application.setStatus(dto.getStatus());
        application.setJobUrl(dto.getJobUrl());
        application.setJobDescription(dto.getJobDescription());
        application.setNotes(dto.getNotes());
        application.setRecruiterName(dto.getRecruiterName());
        application.setRecruiterEmail(dto.getRecruiterEmail());
        application.setRecruiterPhone(dto.getRecruiterPhone());
        application.setInterviewDate(dto.getInterviewDate());
        application.setSalary(dto.getSalary());
        
        Application updated = applicationRepository.save(application);
        return convertToDTO(updated);
    }
    
    public void deleteApplication(Long id, Long userId) {
        Application application = applicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found"));
        
        if (!application.getUserId().equals(userId)) {
            throw new RuntimeException("Unauthorized access to this application");
        }
        
        applicationRepository.deleteById(id);
    }
    
    public ApplicationDTO getApplicationById(Long id, Long userId) {
        Application application = applicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found"));
        
        if (!application.getUserId().equals(userId)) {
            throw new RuntimeException("Unauthorized access to this application");
        }
        
        return convertToDTO(application);
    }
    
    public List<ApplicationDTO> getAllApplications(Long userId) {
        return applicationRepository.findByUserIdOrderByAppliedDateDesc(userId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public List<ApplicationDTO> getApplicationsByStatus(Long userId, ApplicationStatus status) {
        return applicationRepository.findByUserIdAndStatus(userId, status)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public List<ApplicationDTO> searchByCompany(Long userId, String company) {
        return applicationRepository.findByCompanyContainingIgnoreCase(company)
                .stream()
                .filter(app -> app.getUserId().equals(userId))
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    private ApplicationDTO convertToDTO(Application application) {
        return new ApplicationDTO(
                application.getId(),
                application.getCompany(),
                application.getPosition(),
                application.getStatus(),
                application.getJobUrl(),
                application.getJobDescription(),
                application.getNotes(),
                application.getRecruiterName(),
                application.getRecruiterEmail(),
                application.getRecruiterPhone(),
                application.getAppliedDate(),
                application.getInterviewDate(),
                application.getSalary(),
                application.getCreatedAt(),
                application.getUpdatedAt()
        );
    }
}
