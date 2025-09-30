package com.tushar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tushar.entity.Patient;

public interface IPatientRepository extends JpaRepository<Patient, Integer>{

}
