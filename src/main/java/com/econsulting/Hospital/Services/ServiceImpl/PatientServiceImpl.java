package com.econsulting.Hospital.Services.ServiceImpl;

import com.econsulting.Hospital.Entities.DTO.PatientDTO;
import com.econsulting.Hospital.Entities.Patient;
import com.econsulting.Hospital.Repositories.PatientRepository;
import com.econsulting.Hospital.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<PatientDTO> getAllPatients() {
        return patientRepository.findAll().stream()
                .map(patient -> {
                    PatientDTO dto = new PatientDTO();
                    dto.setId(patient.getId());
                    dto.setName(patient.getName());
                    return dto;
                }).collect(Collectors.toList());
    }

    @Override
    public PatientDTO getPatientById(Long id) {
        return patientRepository.findById(id)
                .map(patient -> {
                    PatientDTO dto = new PatientDTO();
                    dto.setId(patient.getId());
                    dto.setName(patient.getName());
                    return dto;
                }).orElse(null);
    }

    @Override
    public PatientDTO savePatient(PatientDTO patientDTO) {
        Patient patient = new Patient();
        patient.setName(patientDTO.getName());
        Patient savedPatient = patientRepository.save(patient);
        patientDTO.setId(savedPatient.getId());
        return patientDTO;
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
