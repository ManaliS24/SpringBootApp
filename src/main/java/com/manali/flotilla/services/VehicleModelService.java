package com.manali.flotilla.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manali.flotilla.models.VehicleModel;
import com.manali.flotilla.repositories.VehicleModelRepository;

@Service
public class VehicleModelService {

	@Autowired
	private VehicleModelRepository vehicleModelRepository;

	// return list of countries
	public List<VehicleModel> getVehicleModels() {
		return vehicleModelRepository.findAll();
	}

	// save the location
	public void save(VehicleModel vehicleModel) {
		vehicleModelRepository.save(vehicleModel);
	}

	// get VehicleModel by ID
	public Optional<VehicleModel> getById(int id) {
		return vehicleModelRepository.findById(id);
	}

	// get VehicleModel by ID
	public boolean existsById(int id) {
		return vehicleModelRepository.existsById(id);
	}

	// delete VehicleModel by ID
	public void delete(Integer id) {
		vehicleModelRepository.deleteById(id);
	}	
}
