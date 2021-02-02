package com.analytics;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;


@FeignClient(name="preprocessor-api", url = "http://f142c4e7e4db.ngrok.io/")
public interface PreprocessorProxy {
    @PostMapping(value = "/infer", consumes = "multipart/form-data")
    PreprocessedMat getPreprocessedImage( @RequestBody MultipartFile file );
}
