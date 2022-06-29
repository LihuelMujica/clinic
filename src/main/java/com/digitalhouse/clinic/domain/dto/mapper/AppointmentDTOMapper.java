package com.digitalhouse.clinic.domain.dto.mapper;

import com.digitalhouse.clinic.domain.dto.AppointmentDTO;
import com.digitalhouse.clinic.persistence.entity.Appointment;

import java.util.List;

public interface AppointmentDTOMapper {
    public AppointmentDTO toAppointmentDTO(Appointment appointment);
    public List<AppointmentDTO> toAppointmentDTO(List<Appointment> appointments);
    public Appointment toAppointment(AppointmentDTO appointmentDTO);
    public List<Appointment> toAppointment(List<AppointmentDTO> appointmentDTOs);
}
