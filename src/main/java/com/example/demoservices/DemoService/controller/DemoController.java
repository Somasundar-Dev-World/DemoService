package com.example.demoservices.DemoService.controller;

import com.example.demoservices.DemoService.service.TrackAnyServiceHealth;
import model.HealthResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private TrackAnyServiceHealth serviceHealth;

    @GetMapping("/service/health")
    public HealthResponse healthCheck() {

        logger.info("Request received to check the health of the service");
        HealthResponse response = new HealthResponse();
        response.setStatus(HealthResponse.Status.SUCCESS);
        response.setResponse("The service is healthy and it is working fine.");

        logger.info("Health response sent successfully.");
        return response;
    }

    @GetMapping("/service/dependent/health")
    public HealthResponse dependentServiceHealthCheck() {

        logger.info("Request received to check the health of the service");

        serviceHealth.callTrackAnyService();

        HealthResponse response = new HealthResponse();
        response.setStatus(HealthResponse.Status.SUCCESS);
        response.setResponse("The dependendent service health is also good. Got a successful response from Track any service");

        logger.info("Health response sent successfully.");
        return response;
    }


}
