package com.careercopilot.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {
    
    @GetMapping
    public HealthResponse health() {
        return new HealthResponse("UP");
    }
    
    public static class HealthResponse {
        public String status;
        public String appName = "Career Copilot Backend";
        
        public HealthResponse(String status) {
            this.status = status;
        }
    }
}
