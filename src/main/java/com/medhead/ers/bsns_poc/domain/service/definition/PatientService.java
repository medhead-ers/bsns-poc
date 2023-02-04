package com.medhead.ers.bsns_poc.domain.service.definition;

import com.medhead.ers.bsns_poc.domain.entity.Patient;

import java.util.List;
import java.util.UUID;

public interface PatientService {
    Patient savePatient(Patient patient);
    List<Patient> getAllPatient();
    Patient getPatientById(UUID uuid);
}
