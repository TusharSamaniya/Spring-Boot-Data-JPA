package com.tushar.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.*;


import com.tushar.entity.Customer;
import com.tushar.service.CustomerManagementServiceImpl;
import com.tushar.service.ICustomerManagementService;

@Component
public class CrudRepoTestRunner implements CommandLineRunner {

    private final CustomerManagementServiceImpl custService_1;
	
	@Autowired
	private ICustomerManagementService custService;

    CrudRepoTestRunner(CustomerManagementServiceImpl custService_1) {
        this.custService_1 = custService_1;
    }

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
			 * List<Customer> list = List.of(new Customer("rohan", "hyd", 9000.0f), new
			 * Customer("rinku", "delhi", 8999.0f), new Customer("ritik",
			 * "ahmedbad",74125.0f), new Customer("payal", "pune", 8709.0f)); //list.of(-),
			 * Set.of(-), // Map.of(-) are from java 9 String resultMsg =
			 * custService.regersterCustomerGroup(list); System.out.println(resultMsg);
			 */
			
			/*
			 * boolean flag = custService.isCustomerAvailable(52); System.out.println(flag);
			 */
			
			/*
			 * long count = custService.getCustomerCount(); System.out.println(count);
			 */
			
			
			/*
			 * Iterable<Customer> it = custService.getAllCustomer(); it.forEach(cust -> {
			 * System.out.println(cust); });
			 * System.out.println("---------------------------------");
			 * it.forEach(System.out::println);
			 */
			 
			 
			
			
			
			/* System.out.println(custService.fetchCustomerById(5)); */
			
			/* System.out.println(custService.adjustCustomerBillAmt(52, 20.0f)); */
			
			
			/*
			 * Customer cust = new Customer(1150, "nuresh", "delhi", 99000/0f);
			 * System.out.println(custService.regesterUpdateCustomerDetails(cust));
			 */
			 
			 
//			System.out.println(custService.removeCustomerById(52));
			/*
			 * Customer cust = new Customer(); cust.setCno(53);
			 * System.out.println(custService.deleteCustomer(cust));
			 */
			
//			System.out.println(custService.deleteAllCustomers());
			
			System.out.println(custService.removeAllCustomerById(List.of(1,3)));
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		 
	}

}
