package com.manali.flotilla.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manali.flotilla.models.VehicleHire;
import com.manali.flotilla.repositories.VehicleHireRepository;

@Service
public class VehicleHireService {

	@Autowired
	private VehicleHireRepository vehicleHireRepository;

	// return list of countries
	public List<VehicleHire> getVehicleHires() {
		return vehicleHireRepository.findAll();
	}

	// save the location
	public void save(VehicleHire vehicleMaintenance) {
		vehicleHireRepository.save(vehicleMaintenance);
	}

	// get VehicleHire by ID
	public Optional<VehicleHire> getById(int id) {
		return vehicleHireRepository.findById(id);
	}

	// get VehicleHire by ID
	public boolean existsById(int id) {
		return vehicleHireRepository.existsById(id);
	}

	// delete VehicleHire by ID
	public void delete(Integer id) {
		vehicleHireRepository.deleteById(id);
	}
}
