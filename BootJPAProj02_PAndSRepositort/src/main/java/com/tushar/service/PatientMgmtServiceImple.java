package com.tushar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.tushar.entity.Patient;
import com.tushar.repository.IPatientRepository;

@Service("patientService")
public class PatientMgmtServiceImple implements IPatientMgmtService {
	
	@Autowired
	private IPatientRepository prepo;
	
	@Override
	public Iterable<Patient> getAllPatient(boolean ascOrder, String... properties) {
		Sort sort = Sort.by(ascOrder?Direction.ASC:Direction.DESC, properties);
		Iterable<Patient> it = prepo.findAll(sort);
		return it;
	}
	@Override
	public Page<Patient> getPatientByPageNo(int pageNo, int pageSize) {
		//pagable object
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		//get requested page details
		Page<Patient> page = prepo.findAll(pageable);
		return page;
	}
	
	@Override
	public Page<Patient> getSortedPatientByPageNo(int pageNo, int pageSize, boolean ascOrder, String... properties) {
		//prepare sort object
		Sort sort = Sort.by(ascOrder?Direction.ASC:Direction.DESC, properties);
		
		//pagable object
		Pageable pageable = PageRequest.of(pageNo, pageSize,sort);
		
		//get requested page details
		
		Page<Patient> page = prepo.findAll(pageable);
		return page;
	}
	@Override
	public void showCustomerPageByPage(int pageSize) {
		
		long count = prepo.count();
		long pagesCount = count/pageSize;
		pagesCount=(count%pageSize==0)?pagesCount:++pagesCount;
		
		for(int i = 0; i< pagesCount; ++i){
			//prepare the pageable object
			Pageable pageable = PageRequest.of(i, pageSize);
			Page<Patient> page = prepo.findAll(pageable);
			page.forEach(System.out::println);
			System.out.println("-----------------------" + (page.getNumber()+1) + "/" + page.getTotalPages() + "-----------------------");
		}
	}
	
}
