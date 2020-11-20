package com.dashboard.proxy;

import com.dashboard.model.User;
import com.dashboard.model.UserFullDiagnosis;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient( name = "diagnosis-service", url = "http://localhost:8250")
public interface DiagnosisProxy {

    @PostMapping("/api/diagnosis/create")
    UserFullDiagnosis saveDiagnosis(@RequestBody User user );
}
