package com.manali.flotilla.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manali.flotilla.models.VehicleType;
import com.manali.flotilla.repositories.VehicleTypeRepository;

@Service
public class VehicleTypeService {

	@Autowired
	private VehicleTypeRepository vehicleTypeRepository;

	// return list of countries
	public List<VehicleType> getVehicleTypes() {
		return vehicleTypeRepository.findAll();
	}

	// save the vehicleType
	public void save(VehicleType vehicleType) {
		vehicleTypeRepository.save(vehicleType);
	}

	// get VehicleType by ID
	public Optional<VehicleType> getById(int id) {
		return vehicleTypeRepository.findById(id);
	}

	// get VehicleType by ID
	public boolean existsById(int id) {
		return vehicleTypeRepository.existsById(id);
	}

	// delete VehicleType by ID
	public void delete(Integer id) {
		vehicleTypeRepository.deleteById(id);
	}
}
