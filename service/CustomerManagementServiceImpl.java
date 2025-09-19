package com.tushar.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tushar.entity.Customer;
import com.tushar.repository.ICustomerRepository;

@Service("custService")
public class CustomerManagementServiceImpl implements ICustomerManagementService {
	
	@Autowired
	private ICustomerRepository custRepo;

	@Override
	public String registerCustomer(Customer cust) {
		System.out.println("cust obj data: " + cust);
		//use the repo
		Customer cust1 = custRepo.save(cust);
		System.out.println("cust1 obj datta:" + cust1);
		return "Customer obj is saved (recode inserted) having the id value:" + cust1.getCno();
	}

	 @Override
	public String regersterCustomerGroup(Iterable<Customer> list) {
		if(list != null) {
			//use repo
			Iterable<Customer> it = custRepo.saveAll(list);
			
			//get the size of the collection
			int size = ((Collection) it).size();
			//get id values of the saved customers
			List<Integer> custIds = new ArrayList();
			it.forEach(cust->{
				custIds.add(cust.getCno());
			});
			return size + "no. of customers are regestered the having the id values: " + list.toString();
		}else {
			throw new IllegalArgumentException("invalid inputs");
		} 
	
	
//	@Override
//	public String regersterCustomerGroup(Iterable<Customer> list) {
//		if(list != null) {
//			//use repo
//			Iterable<Customer> it = custRepo.saveAll(list);
//			
//			//get the size of the collection
//			int size = ((Collection) it).size();
//			//get id values of the saved customers
//			List<Integer> custIds = (List<Integer>) ((Collection)it).stream().map(cust->cust.getClass()).collect(Collectors.toList());
//			return size + "no. of customers are regestered the having the id values: " + list.toString();
//		}else {
//			throw new IllegalArgumentException("invalid inputs");
//		}
//	
//	}

}

	 @Override
	 public boolean isCustomerAvailable(Integer id) {
		// use repo
		 boolean flag = custRepo.existsById(id);
		 
		return flag;
	 }

	 @Override
	 public long getCustomerCount() {
		//use repo
		 long count = custRepo.count();
		 
		return count;
	 }
}
