package com.careercopilot.backend.controller;

import com.careercopilot.backend.dto.ApplicationDTO;
import com.careercopilot.backend.model.ApplicationStatus;
import com.careercopilot.backend.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
@RequiredArgsConstructor
public class ApplicationController {
    
    private final ApplicationService applicationService;
    
    // Temporary: using fixed userId of 1 for testing
    private static final Long CURRENT_USER_ID = 1L;
    
    @GetMapping
    public ResponseEntity<List<ApplicationDTO>> getAllApplications() {
        List<ApplicationDTO> applications = applicationService.getAllApplications(CURRENT_USER_ID);
        return ResponseEntity.ok(applications);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ApplicationDTO> getApplicationById(@PathVariable Long id) {
        ApplicationDTO application = applicationService.getApplicationById(id, CURRENT_USER_ID);
        return ResponseEntity.ok(application);
    }
    
    @PostMapping
    public ResponseEntity<ApplicationDTO> createApplication(@RequestBody ApplicationDTO dto) {
        ApplicationDTO created = applicationService.createApplication(dto, CURRENT_USER_ID);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ApplicationDTO> updateApplication(
            @PathVariable Long id,
            @RequestBody ApplicationDTO dto) {
        ApplicationDTO updated = applicationService.updateApplication(id, dto, CURRENT_USER_ID);
        return ResponseEntity.ok(updated);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
        applicationService.deleteApplication(id, CURRENT_USER_ID);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/status/{status}")
    public ResponseEntity<List<ApplicationDTO>> getApplicationsByStatus(
            @PathVariable ApplicationStatus status) {
        List<ApplicationDTO> applications = applicationService.getApplicationsByStatus(CURRENT_USER_ID, status);
        return ResponseEntity.ok(applications);
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<ApplicationDTO>> searchByCompany(
            @RequestParam String company) {
        List<ApplicationDTO> applications = applicationService.searchByCompany(CURRENT_USER_ID, company);
        return ResponseEntity.ok(applications);
    }
}
