package com.diagnosis.dao;

import com.diagnosis.model.Prediction;
import com.diagnosis.model.PredictionRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;


@FeignClient(name="preprocessor-api", url = "http://90ff895756a4.ngrok.io/")
public interface PredictorProxy {
    @PostMapping(value = "/infer", consumes = "multipart/form-data")
    Prediction getPreprocessedImage(@RequestBody PredictionRequest predictionRequest);
}
