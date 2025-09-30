package com.tushar.service;


import java.util.List;

import com.tushar.entity.Customer;

public interface ICustomerManagementService {
	
	public String registerCustomer(Customer cust);
	public String regersterCustomerGroup(Iterable<Customer> list);
	public boolean isCustomerAvailable(Integer id);
	public long getCustomerCount();
	public Iterable<Customer> getAllCustomer();
	public String showCustomerById(int id);
	public Customer findCustomerById(int id);
	public Customer fetchCustomerById(int id);
	public String adjustCustomerBillAmt(int id, float discountPercentage);
	public String regesterUpdateCustomerDetails(Customer customer);
	public String removeCustomerById(int id);
	public String deleteCustomer(Customer cust);
	public String deleteAllCustomers();
	public String removeAllCustomerById(List<Integer> ids);
}
