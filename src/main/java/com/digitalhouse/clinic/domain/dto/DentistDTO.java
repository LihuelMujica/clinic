package com.digitalhouse.clinic.domain.dto;

import com.digitalhouse.clinic.persistence.entity.Address;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DentistDTO {
    private Integer id;
    private String nombre;
    private String apellido;
    private String license;

}
