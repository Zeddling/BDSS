package com.analytics.model;

public class Prediction {
    private String class_name;
    private String benign;
    private String malignant;
    private String normal;

    public Prediction() {
    }

    public Prediction(String class_name, String benign, String malignant, String normal) {
        this.class_name = class_name;
        this.benign = benign;
        this.malignant = malignant;
        this.normal = normal;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getBenign() {
        return benign;
    }

    public void setBenign(String benign) {
        this.benign = benign;
    }

    public String getMalignant() {
        return malignant;
    }

    public void setMalignant(String malignant) {
        this.malignant = malignant;
    }

    public String getNormal() {
        return normal;
    }

    public void setNormal(String normal) {
        this.normal = normal;
    }

    @Override
    public String toString() {
        return "Prediction{" +
                "class_name='" + class_name + '\'' +
                ", benign='" + benign + '\'' +
                ", malignant='" + malignant + '\'' +
                ", normal='" + normal + '\'' +
                '}';
    }
}
