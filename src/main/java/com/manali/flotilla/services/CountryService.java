package com.manali.flotilla.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manali.flotilla.models.Country;
import com.manali.flotilla.repositories.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;

	// return list of countries
	public List<Country> getCountries() {
		return countryRepository.findAll();
	}

	// save the country
	public void save(Country country) {
		countryRepository.save(country);
	}

	// get Country by ID
	public Optional<Country> getById(int id) {
		return countryRepository.findById(id);
	}

	// get Country by ID
	public boolean existsById(int id) {
		return countryRepository.existsById(id);
	}

	// delete Country by ID
	public void delete(Integer id) {
		countryRepository.deleteById(id);
	}
}
