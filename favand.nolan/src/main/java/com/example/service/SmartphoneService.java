package com.example.service;

import com.example.demo.dto.SmartphoneDto;
import com.example.demo.model.SmartphoneModel;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SmartphoneService {

    private List<SmartphoneModel> smartphoneList = new ArrayList<>();
    private long idCounter = 1;

    public Collection<SmartphoneDto> getAllSmartphones() {
        return smartphoneList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public SmartphoneDto getSmartphone(long id) {
        Optional<SmartphoneModel> smartphone = smartphoneList.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst();
        return smartphone.map(this::convertToDto).orElse(null);
    }

    
    public SmartphoneDto createSmartphone(SmartphoneDto smartphoneDto) {
        SmartphoneModel smartphone = convertToModel(smartphoneDto);
        smartphone.setId(idCounter++);  
        smartphoneList.add(smartphone);
        return convertToDto(smartphone);
    }

 
    public SmartphoneDto updateSmartphone(SmartphoneDto smartphoneDto, long id) {
        Optional<SmartphoneModel> optionalSmartphone = smartphoneList.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst();

        if (optionalSmartphone.isPresent()) {
            SmartphoneModel smartphone = optionalSmartphone.get();
            smartphone.setSerialNumber(smartphoneDto.getSerialNumber());
            smartphone.setBrand(smartphoneDto.getBrand());
            smartphone.setReleaseDate(smartphoneDto.getReleaseDate());
            smartphone.setStatus(smartphoneDto.getStatus());
            return convertToDto(smartphone);
        }
        return null;
    }

    public boolean deleteSmartphone(long id) {
        return smartphoneList.removeIf(smartphone -> smartphone.getId().equals(id));
    }

    private SmartphoneDto convertToDto(SmartphoneModel smartphone) {
        SmartphoneDto dto = new SmartphoneDto();
        dto.setId(smartphone.getId());
        dto.setSerialNumber(smartphone.getSerialNumber());
        dto.setBrand(smartphone.getBrand());
        dto.setReleaseDate(smartphone.getReleaseDate());
        dto.setStatus(smartphone.getStatus());
        return dto;
    }


    private SmartphoneModel convertToModel(SmartphoneDto dto) {
        SmartphoneModel smartphone = new SmartphoneModel();
        smartphone.setSerialNumber(dto.getSerialNumber());
        smartphone.setBrand(dto.getBrand());
        smartphone.setReleaseDate(dto.getReleaseDate());
        smartphone.setStatus(dto.getStatus());
        return smartphone;
    }
}
