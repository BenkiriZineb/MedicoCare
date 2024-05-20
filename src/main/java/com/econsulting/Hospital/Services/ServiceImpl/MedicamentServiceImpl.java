package com.econsulting.Hospital.Services.ServiceImpl;

import com.econsulting.Hospital.Entities.DTO.MedicamentDTO;
import com.econsulting.Hospital.Entities.Medicament;
import com.econsulting.Hospital.Repositories.MedicamentRepository;
import com.econsulting.Hospital.Services.MedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicamentServiceImpl implements MedicamentService {
    @Autowired
    private MedicamentRepository medicamentRepository;

    @Override
    public List<MedicamentDTO> getAllMedicaments() {
        return medicamentRepository.findAll().stream()
                .map(medicament -> {
                    MedicamentDTO dto = new MedicamentDTO();
                    dto.setId(medicament.getId());
                    dto.setName(medicament.getName());
                    return dto;
                }).collect(Collectors.toList());
    }

    @Override
    public MedicamentDTO getMedicamentById(Long id) {
        return medicamentRepository.findById(id)
                .map(medicament -> {
                    MedicamentDTO dto = new MedicamentDTO();
                    dto.setId(medicament.getId());
                    dto.setName(medicament.getName());
                    return dto;
                }).orElse(null);
    }

    @Override
    public MedicamentDTO saveMedicament(MedicamentDTO medicamentDTO) {
        Medicament medicament = new Medicament();
        medicament.setName(medicamentDTO.getName());
        Medicament savedMedicament = medicamentRepository.save(medicament);
        medicamentDTO.setId(savedMedicament.getId());
        return medicamentDTO;
    }

    @Override
    public void deleteMedicament(Long id) {
        medicamentRepository.deleteById(id);
    }
}
