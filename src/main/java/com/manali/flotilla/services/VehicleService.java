package com.manali.flotilla.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manali.flotilla.models.Vehicle;
import com.manali.flotilla.repositories.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	// return list of countries
	public List<Vehicle> getVehicles() {
		return vehicleRepository.findAll();
	}

	// save the vehicle
	public void save(Vehicle vehicle) {
		vehicleRepository.save(vehicle);
	}

	// get Vehicle by ID
	public Optional<Vehicle> getById(int id) {
		return vehicleRepository.findById(id);
	}

	// get Vehicle by ID
	public boolean existsById(int id) {
		return vehicleRepository.existsById(id);
	}

	// delete Vehicle by ID
	public void delete(Integer id) {
		vehicleRepository.deleteById(id);
	}
}
