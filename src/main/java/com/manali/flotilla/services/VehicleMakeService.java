package com.manali.flotilla.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manali.flotilla.models.VehicleMake;
import com.manali.flotilla.repositories.VehicleMakeRepository;

@Service
public class VehicleMakeService {

	@Autowired
	private VehicleMakeRepository vehicleMakeRepository;

	// return list of countries
	public List<VehicleMake> getVehicleMakes() {
		return vehicleMakeRepository.findAll();
	}

	// save the location
	public void save(VehicleMake vehicleMake) {
		vehicleMakeRepository.save(vehicleMake);
	}

	// get VehicleMake by ID
	public Optional<VehicleMake> getById(int id) {
		return vehicleMakeRepository.findById(id);
	}

	// get VehicleMake by ID
	public boolean existsById(int id) {
		return vehicleMakeRepository.existsById(id);
	}

	// delete VehicleMake by ID
	public void delete(Integer id) {
		vehicleMakeRepository.deleteById(id);
	}
}
