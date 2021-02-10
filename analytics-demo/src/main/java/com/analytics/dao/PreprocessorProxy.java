package com.analytics.dao;

import com.analytics.model.Prediction;
import com.analytics.model.PredictionRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;


@FeignClient(name="preprocessor-api", url = "http://da2cef55084a.ngrok.io/")
public interface PreprocessorProxy {
    @PostMapping(value = "/infer", consumes = "multipart/form-data")
    Prediction getPreprocessedImage(@RequestBody PredictionRequest predictionRequest);
}
