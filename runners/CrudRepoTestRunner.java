package com.tushar.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.*;


import com.tushar.entity.Customer;
import com.tushar.service.ICustomerManagementService;

@Component
public class CrudRepoTestRunner implements CommandLineRunner {
	
	@Autowired
	private ICustomerManagementService custService;

	@Override
	public void run(String... args) throws Exception {
		
		
		 /* Customer cust = new Customer();
		  System.out.println("Repo's inMemory Proxy class name: " +
		  custService.getClass());
		  System.out.println("Repo's inMemory Proxy class Interface: " +
		  Arrays.toString(custService.getClass().getInterfaces()));
		  System.out.println("Repo's inMemory Proxy class methods: " +
		  Arrays.toString(custService.getClass().getMethods()));
		  
		  System.out.println("cust obj data: " + cust); cust.setCname("rinku");
		  cust.setCaddrs("south"); cust.setBillAmt(1006.0f); String msg =
		  custService.registerCustomer(cust); System.out.println(msg); */
		
		//example on saveAll(-)
		
		//old method 
		try {
			/*
			 * List<Customer> list = List.of(new Customer("rajan", "hyd", 9000.0f), new
			 * Customer("jiya", "delhi", 8999.0f), new Customer("harshita", "ahmedbad",
			 * 74125.0f), new Customer("chetna", "pune", 8709.0f)); //list.of(-), Set.of(-),
			 * Map.of(-) are from java 9 String resultMsg =
			 * custService.regersterCustomerGroup(list); System.out.println(resultMsg);
			 */
			
			/*
			 * boolean flag = custService.isCustomerAvailable(52); System.out.println(flag);
			 */
			
			/*
			 * long count = custService.getCustomerCount(); System.out.println(count);
			 */
			
			Iterable<Customer> it = custService.getAllCustomer();
			it.forEach(cust -> {
				System.out.println(cust);
			});
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		 
	}

}
