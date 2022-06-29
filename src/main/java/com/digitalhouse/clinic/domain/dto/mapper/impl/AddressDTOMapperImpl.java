package com.digitalhouse.clinic.domain.dto.mapper.impl;

import com.digitalhouse.clinic.domain.dto.AddressDTO;
import com.digitalhouse.clinic.domain.dto.PatientDTO;
import com.digitalhouse.clinic.domain.dto.mapper.AddressDTOMapper;
import com.digitalhouse.clinic.persistence.entity.Address;
import com.digitalhouse.clinic.persistence.entity.Patient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.List;
import java.util.stream.Collectors;

public class AddressDTOMapperImpl implements AddressDTOMapper {
    private ObjectMapper mapper;

    public AddressDTOMapperImpl(ObjectMapper mapper) {
        this.mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
    }


    @Override
    public AddressDTO toDTO(Address c) {
        return mapper.convertValue(c, AddressDTO.class);    }

    @Override
    public List<AddressDTO> toDTO(List<Address> c) {
        return c.stream().map(this::toDTO).collect(Collectors.toList());    }

    @Override
    public Address toEntity(AddressDTO d) {
        return mapper.convertValue(d, Address.class);
    }

    @Override
    public List<Address> toEntity(List<AddressDTO> d) {
        return d.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
