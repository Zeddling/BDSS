package com.analytics.model;

import org.springframework.web.multipart.MultipartFile;

public class PredictionRequest {

    private MultipartFile file;

    public PredictionRequest() {
    }

    public PredictionRequest(MultipartFile file) {
        this.file = file;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
