package com.digitalhouse.clinic.domain.dto.mapper.impl;

import com.digitalhouse.clinic.domain.dto.DentistDTO;
import com.digitalhouse.clinic.domain.dto.PatientDTO;
import com.digitalhouse.clinic.domain.dto.mapper.PatientDTOMapper;
import com.digitalhouse.clinic.persistence.entity.Dentist;
import com.digitalhouse.clinic.persistence.entity.Patient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PatientDTOMapperImpl implements PatientDTOMapper {
    private ObjectMapper mapper;

    public PatientDTOMapperImpl(ObjectMapper mapper) {
        this.mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
    }


    @Override
    public PatientDTO toDTO(Patient c) {
        return mapper.convertValue(c, PatientDTO.class);    }

    @Override
    public List<PatientDTO> toDTO(List<Patient> c) {
        return c.stream().map(this::toDTO).collect(Collectors.toList());    }

    @Override
    public Patient toEntity(PatientDTO d) {
        return mapper.convertValue(d, Patient.class);
    }

    @Override
    public List<Patient> toEntity(List<PatientDTO> d) {
        return d.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
