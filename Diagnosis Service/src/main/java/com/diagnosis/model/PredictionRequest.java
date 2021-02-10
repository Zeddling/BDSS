package com.diagnosis.model;

import org.springframework.web.multipart.MultipartFile;

public class PredictionRequest {

    private MultipartFile multipartFile;

    public PredictionRequest() {
    }

    public PredictionRequest(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }
}
