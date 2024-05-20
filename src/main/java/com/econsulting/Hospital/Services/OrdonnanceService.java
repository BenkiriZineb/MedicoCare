package com.econsulting.Hospital.Services;


import com.econsulting.Hospital.Entities.DTO.OrdonnanceDTO;

import java.util.List;

public interface OrdonnanceService {
    List<OrdonnanceDTO> getAllOrdonnances();
    OrdonnanceDTO getOrdonnanceById(Long id);
    OrdonnanceDTO saveOrdonnance(OrdonnanceDTO ordonnanceDTO);
    void deleteOrdonnance(Long id);
}
