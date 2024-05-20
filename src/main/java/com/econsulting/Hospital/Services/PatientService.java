package com.econsulting.Hospital.Services;


import com.econsulting.Hospital.Entities.DTO.PatientDTO;

import java.util.List;

public interface PatientService {
    List<PatientDTO> getAllPatients();
    PatientDTO getPatientById(Long id);
    PatientDTO savePatient(PatientDTO patientDTO);
    void deletePatient(Long id);
}
