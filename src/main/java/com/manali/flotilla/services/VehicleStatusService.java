package com.manali.flotilla.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manali.flotilla.models.VehicleStatus;
import com.manali.flotilla.models.VehicleStatus;
import com.manali.flotilla.repositories.VehicleStatusRepository;

@Service
public class VehicleStatusService {

	@Autowired
	private VehicleStatusRepository vehicleStatusRepository;

	// return list of countries
	public List<VehicleStatus> getVehicleStatuses() {
		return vehicleStatusRepository.findAll();
	}

	// save the vehicleStatus
	public void save(VehicleStatus vehicleStatus) {
		vehicleStatusRepository.save(vehicleStatus);
	}

	// get VehicleStatus by ID
	public Optional<VehicleStatus> getById(int id) {
		return vehicleStatusRepository.findById(id);
	}

	// get VehicleStatus by ID
	public boolean existsById(int id) {
		return vehicleStatusRepository.existsById(id);
	}

	// delete VehicleStatus by ID
	public void delete(Integer id) {
		vehicleStatusRepository.deleteById(id);
	}
}
