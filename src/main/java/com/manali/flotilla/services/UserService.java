package com.manali.flotilla.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.manali.flotilla.models.User;
import com.manali.flotilla.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired private BCryptPasswordEncoder encoder;
	
	@Autowired
	private UserRepository userRepository;

	// return list of countries
	public List<User> getVehicleHires() {
		return userRepository.findAll();
	}

	// save the location
	public void save(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
	}


}
