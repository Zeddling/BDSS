package com.diagnosis.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "analytics-service")
public interface AnalyticsProxy {
    @PostMapping("/predict")

}
