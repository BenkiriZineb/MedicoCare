package com.econsulting.Hospital.Services.ServiceImpl;

import com.econsulting.Hospital.Entities.DTO.OrdonnanceDTO;
import com.econsulting.Hospital.Entities.Medicament;
import com.econsulting.Hospital.Entities.Ordonnance;
import com.econsulting.Hospital.Repositories.DoctorRepository;
import com.econsulting.Hospital.Repositories.MedicamentRepository;
import com.econsulting.Hospital.Repositories.OrdonnanceRepository;
import com.econsulting.Hospital.Repositories.PatientRepository;
import com.econsulting.Hospital.Services.OrdonnanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdonnanceServiceImpl implements OrdonnanceService {
    @Autowired
    private OrdonnanceRepository ordonnanceRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private MedicamentRepository medicamentRepository;

    @Override
    public List<OrdonnanceDTO> getAllOrdonnances() {
        return ordonnanceRepository.findAll().stream()
                .map(ordonnance -> {
                    OrdonnanceDTO dto = new OrdonnanceDTO();
                    dto.setId(ordonnance.getId());
                    dto.setDoctorId(ordonnance.getDoctor().getId());
                    dto.setPatientId(ordonnance.getPatient().getId());
                    dto.setMedicamentIds(ordonnance.getMedicaments().stream().map(Medicament::getId).collect(Collectors.toList()));
                    return dto;
                }).collect(Collectors.toList());
    }

    @Override
    public OrdonnanceDTO getOrdonnanceById(Long id) {
        return ordonnanceRepository.findById(id)
                .map(ordonnance -> {
                    OrdonnanceDTO dto = new OrdonnanceDTO();
                    dto.setId(ordonnance.getId());
                    dto.setDoctorId(ordonnance.getDoctor().getId());
                    dto.setPatientId(ordonnance.getPatient().getId());
                    dto.setMedicamentIds(ordonnance.getMedicaments().stream().map(Medicament::getId).collect(Collectors.toList()));
                    return dto;
                }).orElse(null);
    }

    @Override
    public OrdonnanceDTO saveOrdonnance(OrdonnanceDTO ordonnanceDTO) {
        Ordonnance ordonnance = new Ordonnance();
        ordonnance.setDoctor(doctorRepository.findById(ordonnanceDTO.getDoctorId()).orElse(null));
        ordonnance.setPatient(patientRepository.findById(ordonnanceDTO.getPatientId()).orElse(null));
        ordonnance.setMedicaments(ordonnanceDTO.getMedicamentIds().stream()
                .map(medicamentRepository::findById)
                .filter(java.util.Optional::isPresent)
                .map(java.util.Optional::get)
                .collect(Collectors.toList()));
        Ordonnance savedOrdonnance = ordonnanceRepository.save(ordonnance);
        ordonnanceDTO.setId(savedOrdonnance.getId());
        return ordonnanceDTO;
    }

    @Override
    public void deleteOrdonnance(Long id) {
        ordonnanceRepository.deleteById(id);
    }
}
