package com.econsulting.Hospital.Controllers;

import com.econsulting.Hospital.Entities.DTO.OrdonnanceDTO;
import com.econsulting.Hospital.Services.OrdonnanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordonnances")
public class OrdonnanceController {
    @Autowired
    private OrdonnanceService ordonnanceService;

    @GetMapping
    public List<OrdonnanceDTO> getAllOrdonnances() {
        return ordonnanceService.getAllOrdonnances();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdonnanceDTO> getOrdonnanceById(@PathVariable Long id) {
        OrdonnanceDTO ordonnance = ordonnanceService.getOrdonnanceById(id);
        if (ordonnance != null) {
            return ResponseEntity.ok(ordonnance);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public OrdonnanceDTO createOrdonnance(@RequestBody OrdonnanceDTO ordonnanceDTO) {
        return ordonnanceService.saveOrdonnance(ordonnanceDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteOrdonnance(@PathVariable Long id) {
        ordonnanceService.deleteOrdonnance(id);
    }
}
