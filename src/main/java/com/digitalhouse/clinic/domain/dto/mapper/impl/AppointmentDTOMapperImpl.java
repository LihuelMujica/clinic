package com.digitalhouse.clinic.domain.dto.mapper.impl;

import com.digitalhouse.clinic.domain.dto.AppointmentDTO;
import com.digitalhouse.clinic.domain.dto.mapper.AppointmentDTOMapper;
import com.digitalhouse.clinic.persistence.entity.Appointment;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AppointmentDTOMapperImpl implements AppointmentDTOMapper {

    private ObjectMapper mapper;

    public AppointmentDTOMapperImpl() {
        this.mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
    }

    @Override
    public AppointmentDTO toAppointmentDTO(Appointment appointment) {
        return mapper.convertValue(appointment,AppointmentDTO.class);
    }

    @Override
    public List<AppointmentDTO> toAppointmentDTO(List<Appointment> appointments) {
        return appointments.stream().map(this::toAppointmentDTO).collect(Collectors.toList());
    }

    @Override
    public Appointment toAppointment(AppointmentDTO appointmentDTO) {
        return mapper.convertValue(appointmentDTO,Appointment.class);
    }

    @Override
    public List<Appointment> toAppointment(List<AppointmentDTO> appointmentDTOs) {
        return appointmentDTOs.stream().map(this::toAppointment).collect(Collectors.toList());
    }
}
