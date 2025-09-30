package com.tushar.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

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

	 @Override
	 public Iterable<Customer> getAllCustomer() {
		// use repo
		 Iterable<Customer> it = custRepo.findAll();
		return it;
	 }

	 @Override
	 public String showCustomerById(int id) {
		Optional<Customer> opt = custRepo.findById(id);
		if(opt.isPresent()) return id + " customer details are: " +opt.get().toString();
		return id+ " customer not fount";
		}

	 @Override
	 public Customer findCustomerById(int id) {
		 
		//method 1
		/*
		 * Optional<Customer> opt = custRepo.findById(id); if(opt.isPresent()) return
		 * opt.get(); throw new IllegalArgumentException("Customer Not found");
		 */
		 
		 //method 2
		 return custRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Customer not found"));
	 }
	  
	 @Override
	public Customer fetchCustomerById(int id) {
		return custRepo.findById(id).orElse(new Customer(00,"xxx","zzz",00.0f));
	}
	 @Override
	public String adjustCustomerBillAmt(int id, float discountPercentage) {
		Optional<Customer> opt = custRepo.findById(id);
		if(opt.isPresent()) {
			Customer cust = opt.get();
			float discount = cust.getBillAmt()*(discountPercentage/100.0f);
			cust.setBillAmt(cust.getBillAmt()-discount);
			custRepo.save(cust);
			return id + " customer details are updated";
		}
		return id + " customer not found";
	}
	 @Override
	public String regesterUpdateCustomerDetails(Customer customer) {
		//get the customer detail based on the given id
		 Optional<Customer> opt = custRepo.findById(customer.getCno());
		 if(opt.isPresent()) {
			 custRepo.save(customer);
			 return customer.getCno() + " id details are updated";
		 }else {
			 int idVal = custRepo.save(customer).getCno();
			 return "customer details are inserted with the id value: "  + idVal;
		 }
	}
	 
	 @Override
	public String removeCustomerById(int id) {
		Optional<Customer> opt = custRepo.findById(id);
		if(opt.isPresent()) {
			custRepo.deleteById(id);
			return id + " customer is found and deleted";
		}
		return id + " customer is not found for deletion";
	}
	 @Override
	public String deleteCustomer(Customer cust) {
		Optional<Customer> opt = custRepo.findById(cust.getCno());
		if(opt.isPresent()) {
			custRepo.delete(cust);
			return cust.getCno() + " customer found and deleted";
		}
		return cust.getCno() + " customer not found";
	}
	 @Override
	public String deleteAllCustomers() {
		//get the customer count
		 long count = custRepo.count();
		 if(count > 0) { 
			 custRepo.deleteAll();
			 return count + " noof total records are found and deleted";
		 }else {
			 return "no customer is deleted";
		 }
	}
	 @Override
	public String removeAllCustomerById(List<Integer> ids) {
		 List<Customer> list = (List<Customer>) custRepo.findAllById(ids);
		 if(ids.size() == list.size()) {
			 custRepo.deleteAllById(ids);
			 return ids.size() + " no of records are deleted";
		 }
		return "records are not found for deletion";
	}
}
