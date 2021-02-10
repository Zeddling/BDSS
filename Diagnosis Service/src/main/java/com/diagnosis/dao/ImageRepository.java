package com.diagnosis.dao;

import com.diagnosis.model.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ImageModel, String> {
}
