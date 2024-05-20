package com.econsulting.Hospital.Repositories;

import com.econsulting.Hospital.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PatientRepository extends JpaRepository<Patient, Long> {
}