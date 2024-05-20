package com.econsulting.Hospital.Repositories;

import com.econsulting.Hospital.Entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
