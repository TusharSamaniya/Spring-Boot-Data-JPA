package com.tushar.repository;

import org.springframework.data.repository.CrudRepository;

import com.tushar.entity.Customer;

public interface ICustomerRepository extends CrudRepository<Customer, Integer> {

}
