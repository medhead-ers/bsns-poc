package com.medhead.ers.bsns_pms.application.controller;

import com.medhead.ers.bsns_pms.data.repository.PatientRepository;
import com.medhead.ers.bsns_pms.domain.entity.Patient;
import com.medhead.ers.bsns_pms.exception.PatientNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class PatientController {
    private final PatientRepository patientRepository;
    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    @GetMapping("/patients")
    List<Patient> all(){
        return patientRepository.findAll();
    }

    @GetMapping("/patients/{id}")
    Patient one(@PathVariable UUID id){
        return patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException(id));
    }

    @PostMapping("/patients")
    Patient newPatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }


}
