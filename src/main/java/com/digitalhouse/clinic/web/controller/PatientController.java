package com.digitalhouse.clinic.web.controller;

import com.digitalhouse.clinic.domain.dto.PatientDTO;
import com.digitalhouse.clinic.domain.service.IPatientService;
import com.digitalhouse.clinic.persistence.entity.Patient;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private final IPatientService patientService;

    @Autowired
    public PatientController(IPatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/all")
    @ApiOperation("Get a list of all patients")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<PatientDTO>> getAll(){
        return new ResponseEntity<>(patientService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search for a patient using id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "patient not found")
    })
    public ResponseEntity<PatientDTO> getById(@ApiParam(value = "The id of the patient", required = true, example = "1") @PathVariable("id") int id){
        return patientService.getById(id).
                map(dentist -> new ResponseEntity<>(dentist,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    @ApiOperation("Save a patient on the database")
    @ApiResponse(code = 201, message = "CREATED")
    public ResponseEntity<PatientDTO> save(@RequestBody PatientDTO patient) {
        return new ResponseEntity<>(patientService.save(patient), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Delete a patient using id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Patient not found")
    })
    public ResponseEntity delete(@PathVariable("id") int id) {
        if (patientService.delete(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
