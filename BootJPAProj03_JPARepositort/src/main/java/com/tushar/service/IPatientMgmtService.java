package com.tushar.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;

import com.tushar.entity.Patient;

public interface IPatientMgmtService {
	
	public String deletePatientsByIds(List<Integer> ids);
	public Patient getPatientById(int id);
	public List<Patient> showPatientsByExampleData(Patient psen, boolean ascOrder, String ...properties);
	public String groupReprestation(List<Patient>list);
}
