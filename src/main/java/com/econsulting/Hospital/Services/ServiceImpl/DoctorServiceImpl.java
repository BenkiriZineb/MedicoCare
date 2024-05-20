package com.econsulting.Hospital.Services.ServiceImpl;


import com.econsulting.Hospital.Entities.DTO.DoctorDTO;
import com.econsulting.Hospital.Entities.Doctor;
import com.econsulting.Hospital.Repositories.DoctorRepository;
import com.econsulting.Hospital.Services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<DoctorDTO> getAllDoctors() {
        return doctorRepository.findAll().stream()
                .map(doctor -> {
                    DoctorDTO dto = new DoctorDTO();
                    dto.setId(doctor.getId());
                    dto.setName(doctor.getName());
                    return dto;
                }).collect(Collectors.toList());
    }

    @Override
    public DoctorDTO getDoctorById(Long id) {
        return doctorRepository.findById(id)
                .map(doctor -> {
                    DoctorDTO dto = new DoctorDTO();
                    dto.setId(doctor.getId());
                    dto.setName(doctor.getName());
                    return dto;
                }).orElse(null);
    }

    @Override
    public DoctorDTO saveDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = new Doctor();
        doctor.setName(doctorDTO.getName());
        Doctor savedDoctor = doctorRepository.save(doctor);
        doctorDTO.setId(savedDoctor.getId());
        return doctorDTO;
    }

    @Override
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}
