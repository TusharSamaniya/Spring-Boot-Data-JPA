package com.tushar.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
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
			/*
			 * String msg = service.deletePatientsByIds(Arrays.asList(4,null));
			 * System.out.println(msg);
			 */
			
			/*
			 * Patient patient = service.getPatientById(2); System.out.println(patient ==
			 * null ? "Customer not found": patient);
			 */
			
			/*
			 * Patient p = new Patient(); p.setPAddrs("hyd"); p.setPName("ashu");
			 * List<Patient> list = service.showPatientsByExampleData(p, true, "billAmt",
			 * "pName"); list.forEach(System.out::println);
			 */
			
			Patient p1 = new Patient("ramesh", "byd", 8000.0f);
			Patient p2 = new Patient("raju", "bombay", 1000.0f);
			Patient p3 = new Patient("rani", "pujab", 2000.0f);
			Patient p4 = new Patient("rajini", "amritsar", 3000.0f);
			List<Patient> list = List.of(p1, p2, p3, p4);
			String msg = service.groupReprestation(list);
			System.out.println(msg);
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
