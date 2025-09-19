package com.tushar.service;


import com.tushar.entity.Customer;

public interface ICustomerManagementService {
	
	public String registerCustomer(Customer cust);
	public String regersterCustomerGroup(Iterable<Customer> list);
	public boolean isCustomerAvailable(Integer id);

}
