package com.example.demoservices.DemoService.service;

import com.example.demoservices.DemoService.controller.DemoController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

@Service
public class TrackAnyServiceHealth {

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private TrackAnyServiceFeignClient trackerfeignClient;

    public void callTrackAnyService() {

        logger.info("Going to call track any service. ");

        TrackerHealthResponse response = trackerfeignClient.getTrackerHealthStatus();

        logger.info(" Successfully got the respons ===> "+response.getDescription());
        logger.info("Track Any service call is completed.");


    }

}

