package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.SmartphoneDto;
import com.example.service.SmartphoneService;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class SmartphoneController {

    @Autowired
    private SmartphoneService smartphoneService;
    
    public SmartphoneController(SmartphoneService smartphoneService) {
        this.smartphoneService = smartphoneService;
    }

  
    @GetMapping("/smartphones")
    public Collection<SmartphoneDto> getAllSmartphones() {
        return smartphoneService.getAllSmartphones();
    }

  
    @GetMapping("/smartphones/{id}")
    public ResponseEntity<SmartphoneDto> getSmartphone(@PathVariable long id) {
        SmartphoneDto smartphoneDto = smartphoneService.getSmartphone(id);
        if (smartphoneDto == null) {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
        return ResponseEntity.ok(smartphoneDto); // 200 OK
    }

   
    @PostMapping("/smartphones")
    public SmartphoneDto createSmartphone(@RequestBody SmartphoneDto smartphoneDto) {
        return smartphoneService.createSmartphone(smartphoneDto);
    }

  
    @PutMapping("/smartphones/{id}")
    public SmartphoneDto updateSmartphone(@RequestBody SmartphoneDto smartphoneDto, @PathVariable long id) {
        return smartphoneService.updateSmartphone(smartphoneDto, id);
    }

    @DeleteMapping("/smartphones/{id}")
    public boolean deleteSmartphone(@PathVariable long id) {
        return smartphoneService.deleteSmartphone(id);
    }
}
