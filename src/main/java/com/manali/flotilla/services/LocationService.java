package com.manali.flotilla.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manali.flotilla.models.Location;
import com.manali.flotilla.repositories.LocationRepository;



@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;

	// return list of countries
	public List<Location> getLocations() {
		return locationRepository.findAll();
	}

	// save the location
	public void save(Location location) {
		locationRepository.save(location);
	}

	// get Location by ID
	public Optional<Location> getById(int id) {
		return locationRepository.findById(id);
	}

	// get Location by ID
	public boolean existsById(int id) {
		return locationRepository.existsById(id);
	}

	// delete Location by ID
	public void delete(Integer id) {
		locationRepository.deleteById(id);
	}
}
