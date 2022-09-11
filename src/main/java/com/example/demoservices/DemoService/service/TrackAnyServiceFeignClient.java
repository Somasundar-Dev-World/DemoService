package com.example.demoservices.DemoService.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "track-any-service-service")
@RibbonClient(name="track-any-service-service")
public interface TrackAnyServiceFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/services/health", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public TrackerHealthResponse getTrackerHealthStatus();
}
