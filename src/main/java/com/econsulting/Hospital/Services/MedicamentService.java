package com.econsulting.Hospital.Services;


import com.econsulting.Hospital.Entities.DTO.MedicamentDTO;

import java.util.List;

public interface MedicamentService {
    List<MedicamentDTO> getAllMedicaments();
    MedicamentDTO getMedicamentById(Long id);
    MedicamentDTO saveMedicament(MedicamentDTO medicamentDTO);
    void deleteMedicament(Long id);
}
