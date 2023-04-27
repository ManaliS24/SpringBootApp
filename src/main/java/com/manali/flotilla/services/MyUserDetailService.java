package com.manali.flotilla.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.manali.flotilla.models.User;
import com.manali.flotilla.models.UserPrincipal;
import com.manali.flotilla.repositories.UserRepository;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("User not found!");
		}
		
		return new UserPrincipal(user);
	}

}
