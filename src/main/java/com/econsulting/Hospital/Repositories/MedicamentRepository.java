package com.econsulting.Hospital.Repositories;

import com.econsulting.Hospital.Entities.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MedicamentRepository extends JpaRepository<Medicament, Long> {
}
