package com.econsulting.Hospital.Repositories;

import com.econsulting.Hospital.Entities.Ordonnance;
import org.springframework.data.jpa.repository.JpaRepository;
public interface OrdonnanceRepository extends JpaRepository<Ordonnance, Long> {
}