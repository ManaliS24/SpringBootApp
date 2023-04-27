package com.manali.flotilla.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manali.flotilla.models.Supplier;
import com.manali.flotilla.repositories.SupplierRepository;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;

	// return list of countries
	public List<Supplier> getSuppliers() {
		return supplierRepository.findAll();
	}

	// save the supplier
	public void save(Supplier supplier) {
		supplierRepository.save(supplier);
	}

	// get Supplier by ID
	public Optional<Supplier> getById(int id) {
		return supplierRepository.findById(id);
	}

	// get Supplier by ID
	public boolean existsById(int id) {
		return supplierRepository.existsById(id);
	}

	// delete Supplier by ID
	public void delete(Integer id) {
		supplierRepository.deleteById(id);
	}

}
