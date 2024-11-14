package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.SmartphoneModel;

@Repository
public interface SmartphoneRepository extends JpaRepository<SmartphoneModel, Long> {
 
   List<SmartphoneModel> findByBrand(String brand);
    List<SmartphoneModel> findByStatus(String status);
}
