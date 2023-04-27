package com.manali.flotilla.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manali.flotilla.models.Client;
import com.manali.flotilla.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	// return list of countries
	public List<Client> getClients() {
		return clientRepository.findAll();
	}

	// save the client
	public void save(Client client) {
		clientRepository.save(client);
	}

	// get Client by ID
	public Optional<Client> getById(int id) {
		return clientRepository.findById(id);
	}

	// get Client by ID
	public boolean existsById(int id) {
		return clientRepository.existsById(id);
	}

	// delete Client by ID
	public void delete(Integer id) {
		clientRepository.deleteById(id);
	}
}
