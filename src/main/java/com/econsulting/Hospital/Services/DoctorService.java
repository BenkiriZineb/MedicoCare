package com.econsulting.Hospital.Services;


import com.econsulting.Hospital.Entities.DTO.DoctorDTO;

import java.util.List;

public interface DoctorService {
    List<DoctorDTO> getAllDoctors();
    DoctorDTO getDoctorById(Long id);
    DoctorDTO saveDoctor(DoctorDTO doctorDTO);
    void deleteDoctor(Long id);
}
