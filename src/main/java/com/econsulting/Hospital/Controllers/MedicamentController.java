package com.econsulting.Hospital.Controllers;

import com.econsulting.Hospital.Entities.DTO.MedicamentDTO;
import com.econsulting.Hospital.Services.MedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicaments")
public class MedicamentController {
    @Autowired
    private MedicamentService medicamentService;

    @GetMapping
    public List<MedicamentDTO> getAllMedicaments() {
        return medicamentService.getAllMedicaments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicamentDTO> getMedicamentById(@PathVariable Long id) {
        MedicamentDTO medicament = medicamentService.getMedicamentById(id);
        if (medicament != null) {
            return ResponseEntity.ok(medicament);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public MedicamentDTO createMedicament(@RequestBody MedicamentDTO medicamentDTO) {
        return medicamentService.saveMedicament(medicamentDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteMedicament(@PathVariable Long id) {
        medicamentService.deleteMedicament(id);
    }
}
