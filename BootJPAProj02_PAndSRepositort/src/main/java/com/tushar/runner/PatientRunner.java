package com.tushar.runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import com.tushar.entity.Patient;
import com.tushar.service.IPatientMgmtService;


@Component
public class PatientRunner implements CommandLineRunner {

	
	@Autowired
	private IPatientMgmtService service;


	

	@Override
	public void run(String... args) throws Exception {
		
		try {
			
//			service.getAllPatient(true, "billAmt").forEach(System.out::println);
			
			/*
			 * Page<Patient> page = service.getPatientByPageNo(2, 4);
			 * System.out.println("Request page recored are: ");
			 * page.getContent().forEach(System.out::println);
			 * System.out.println("Total page count:" + page.getTotalPages());
			 * System.out.println("Current page no: " + page.getNumber());
			 * System.out.println("Total no of records: " + page.getTotalElements());
			 * System.out.println("Records in the requested page: " +
			 * page.getNumberOfElements());
			 * System.out.println("Is the request page is last page: " + page.isLast());
			 */
			
			/*
			 * Page<Patient> page = service.getSortedPatientByPageNo(2, 3, true, "billAmt",
			 * "PAddrs"); page.getContent().forEach(System.out::println);
			 */
			
			
			service.showCustomerPageByPage(3);
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
