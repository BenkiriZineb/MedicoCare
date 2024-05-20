package com.econsulting.Hospital.Entities.DTO;

import lombok.Data;
import java.util.List;

@Data
public class OrdonnanceDTO {
    private Long id;
    private Long doctorId;
    private Long patientId;
    private List<Long> medicamentIds;
}