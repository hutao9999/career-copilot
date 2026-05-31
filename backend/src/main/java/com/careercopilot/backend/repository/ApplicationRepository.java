package com.careercopilot.backend.repository;

import com.careercopilot.backend.model.Application;
import com.careercopilot.backend.model.ApplicationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    
    List<Application> findByUserId(Long userId);
    
    List<Application> findByStatus(ApplicationStatus status);
    
    List<Application> findByUserIdAndStatus(Long userId, ApplicationStatus status);
    
    List<Application> findByCompanyContainingIgnoreCase(String company);
    
    List<Application> findByUserIdOrderByAppliedDateDesc(Long userId);
}
