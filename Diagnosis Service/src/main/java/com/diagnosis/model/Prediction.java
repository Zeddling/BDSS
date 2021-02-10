package com.diagnosis.model;

public class Prediction {
    private String class_name;
    private String confidence_level;

    public Prediction() {
    }

    public Prediction(String class_name, String confidence_level) {
        this.class_name = class_name;
        this.confidence_level = confidence_level;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getConfidence_level() {
        return confidence_level;
    }

    public void setConfidence_level(String confidence_level) {
        this.confidence_level = confidence_level;
    }

    @Override
    public String toString() {
        return "PreprocessedMat{" +
                "class_name='" + class_name + '\'' +
                ", confidence_level='" + confidence_level + '\'' +
                '}';
    }
}