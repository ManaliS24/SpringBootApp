package com.manali.flotilla.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manali.flotilla.models.Country;
import com.manali.flotilla.models.State;
import com.manali.flotilla.repositories.StateRepository;

@Service
public class StateService {

	@Autowired
	private StateRepository stateRepository;

	// return list of countries
	public List<State> getStates() {
		return stateRepository.findAll();
	}

	// save the state
	public void save(State state) {
		stateRepository.save(state);
	}

	// get State by ID
	public Optional<State> getById(int id) {
		return stateRepository.findById(id);
	}

	// get State by ID
	public boolean existsById(int id) {
		return stateRepository.existsById(id);
	}

	// delete State by ID
	public void delete(Integer id) {
		stateRepository.deleteById(id);
	}


}