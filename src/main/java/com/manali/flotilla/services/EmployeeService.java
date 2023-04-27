package com.manali.flotilla.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manali.flotilla.models.Employee;
import com.manali.flotilla.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	// return list of countries
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	// save the employee
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	// get Employee by ID
	public Optional<Employee> getById(int id) {
		return employeeRepository.findById(id);
	}

	// get Employee by ID
	public boolean existsById(int id) {
		return employeeRepository.existsById(id);
	}

	// delete Employee by ID
	public void delete(Integer id) {
		employeeRepository.deleteById(id);
	}
}
