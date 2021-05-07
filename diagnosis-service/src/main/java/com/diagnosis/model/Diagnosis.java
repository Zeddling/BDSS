package com.diagnosis.model;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Diagnosis {
    @Id
    private UUID diagnosisId;
    
    private String patientName;
    private String idNumber;
    private LocalDate diagnosisDate;
    private String breast_side;
    private String image_view;
    private String abnormalityType;
    private String massShape;
    private String massMargin;
    private String pathology;
    private String comments;

    public Diagnosis(String patientName, String idNumber, String breast_side, String image_view,
            String abnormalityType, String massShape, String massMargin, String comments) {
        this.patientName = patientName;
        this.idNumber = idNumber;
        this.breast_side = breast_side;
        this.image_view = image_view;
        this.abnormalityType = abnormalityType;
        this.massShape = massShape;
        this.massMargin = massMargin;
        this.comments = comments;
    }
}