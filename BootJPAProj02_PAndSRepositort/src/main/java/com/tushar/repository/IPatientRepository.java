package com.tushar.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.tushar.entity.Patient;

public interface IPatientRepository extends PagingAndSortingRepository<Patient, Integer>, CrudRepository<Patient, Integer> {

}
