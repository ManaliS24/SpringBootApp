package com.manali.flotilla.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manali.flotilla.models.EmployeeType;
import com.manali.flotilla.repositories.EmployeeTypeRepository;

@Service
public class EmployeeTypeService {

	@Autowired
	private EmployeeTypeRepository employeeTypeRepository;

	// return list of countries
	public List<EmployeeType> getEmployeeTypes() {
		return employeeTypeRepository.findAll();
	}

	// save the employeeType
	public void save(EmployeeType employeeType) {
		employeeTypeRepository.save(employeeType);
	}

	// get EmployeeType by ID
	public Optional<EmployeeType> getById(int id) {
		return employeeTypeRepository.findById(id);
	}

	// get EmployeeType by ID
	public boolean existsById(int id) {
		return employeeTypeRepository.existsById(id);
	}

	// delete EmployeeType by ID
	public void delete(Integer id) {
		employeeTypeRepository.deleteById(id);
	}
}
