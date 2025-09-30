package com.tushar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
	public String deletePatientsByIds(List<Integer> ids) {
		List<Patient> list = prepo.findAllById(ids);
		if(list.size() != 0) {
			prepo.deleteAllByIdInBatch(ids); 
			return list.size() + " no or records are deleted";
		}
		return "no recored found for deletion";
	}

	@Override
	public Patient getPatientById(int id) {
		//Patient patient = prepo.getById(id);   ---> Dubricated
		//Patient pateint = prepo.getOne(id);    ---> Dubricated
		Patient pateint = prepo.getReferenceById(id);
		return pateint;
	}
	
	@Override
	public List<Patient> showPatientsByExampleData(Patient psen, boolean ascOrder, String... properties) {
		Example<Patient> example = Example.of(psen);
		Sort sort = Sort.by(ascOrder? Direction.ASC: Direction.DESC,properties);
		List<Patient> list = prepo.findAll(example, sort);
		return list;
	}
	@Override
	public String groupReprestation(List<Patient> list) {
		prepo.saveAllAndFlush(list);
		return list.size() + " number of records are save";
	}
}
