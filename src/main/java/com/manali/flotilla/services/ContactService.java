package com.manali.flotilla.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manali.flotilla.models.Contact;
import com.manali.flotilla.repositories.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;

	// return list of countries
	public List<Contact> getContacts() {
		return contactRepository.findAll();
	}

	// save the contact
	public void save(Contact contact) {
		contactRepository.save(contact);
	}

	// get Contact by ID
	public Optional<Contact> getById(int id) {
		return contactRepository.findById(id);
	}

	// get Contact by ID
	public boolean existsById(int id) {
		return contactRepository.existsById(id);
	}

	// delete Contact by ID
	public void delete(Integer id) {
		contactRepository.deleteById(id);
	}
}
