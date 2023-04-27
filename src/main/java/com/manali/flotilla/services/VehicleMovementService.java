package com.manali.flotilla.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manali.flotilla.models.VehicleMovement;
import com.manali.flotilla.repositories.VehicleMovementRepository;

@Service
public class VehicleMovementService {

	@Autowired
	private VehicleMovementRepository vehicleMovementRepository;

	// return list of countries
	public List<VehicleMovement> getVehicleMovements() {
		return vehicleMovementRepository.findAll();
	}

	// save the location
	public void save(VehicleMovement vehicleMaintenance) {
		vehicleMovementRepository.save(vehicleMaintenance);
	}

	// get VehicleMovement by ID
	public Optional<VehicleMovement> getById(int id) {
		return vehicleMovementRepository.findById(id);
	}

	// get VehicleMovement by ID
	public boolean existsById(int id) {
		return vehicleMovementRepository.existsById(id);
	}

	// delete VehicleMovement by ID
	public void delete(Integer id) {
		vehicleMovementRepository.deleteById(id);
	}
}
