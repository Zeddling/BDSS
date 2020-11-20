package com.diagnosis.dao;

import com.diagnosis.model.UserDiagnosisRequest;
import com.diagnosis.model.UserDiagnosisResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient( name = "analytics-engine", url = "http://localhost:8300")
public interface AnalyticsProxy {

    //  Send mammogram to analytics engine for diagnosis
    @PostMapping ("/get-diagnosis")
    UserDiagnosisResponse getDiagnosis(@RequestBody UserDiagnosisRequest userDiagnosisRequest );

}
