package com.manali.flotilla.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manali.flotilla.models.VehicleMaintenance;
import com.manali.flotilla.repositories.VehicleMaintenanceRepository;

@Service
public class VehicleMaintenanceService {

	@Autowired
	private VehicleMaintenanceRepository vehicleMaintenanceRepository;

	// return list of countries
	public List<VehicleMaintenance> getVehicleMaintenances() {
		return vehicleMaintenanceRepository.findAll();
	}

	// save the location
	public void save(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceRepository.save(vehicleMaintenance);
	}

	// get VehicleMaintenance by ID
	public Optional<VehicleMaintenance> getById(int id) {
		return vehicleMaintenanceRepository.findById(id);
	}

	// get VehicleMaintenance by ID
	public boolean existsById(int id) {
		return vehicleMaintenanceRepository.existsById(id);
	}

	// delete VehicleMaintenance by ID
	public void delete(Integer id) {
		vehicleMaintenanceRepository.deleteById(id);
	}
}
