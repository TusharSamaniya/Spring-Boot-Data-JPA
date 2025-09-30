package com.tushar.service;

import org.springframework.data.domain.Page;

import com.tushar.entity.Patient;

public interface IPatientMgmtService {
	
	public Iterable<Patient> getAllPatient(boolean ascOrder, String ...properties);
	public Page<Patient> getPatientByPageNo(int pageNo, int pageSize);
	public Page<Patient> getSortedPatientByPageNo(int pageNo, int pageSize, boolean ascOrder, String...properties);
	public void showCustomerPageByPage(int pageSize);
	
}
