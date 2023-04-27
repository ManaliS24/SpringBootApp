package com.manali.flotilla.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manali.flotilla.models.Contact;
import com.manali.flotilla.models.Country;
import com.manali.flotilla.models.State;
import com.manali.flotilla.services.ContactService;
import com.manali.flotilla.services.CountryService;
import com.manali.flotilla.services.StateService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@GetMapping("/contacts")
	public String getContacts(Model model) {
		List<Contact> lstcontact = contactService.getContacts();

		model.addAttribute("contacts", lstcontact);
		
		return "contact";
	}

	// save new contact
	@PostMapping("/contacts/addnew")
	public String addContact(Contact contact) {
		contactService.save(contact);
		return "redirect:/contacts";
	}

	// save new contact
	@RequestMapping("contacts/findbyid/")
	@ResponseBody
	public Optional<Contact> getById(int id) {
		return contactService.getById(id);
	}
	
	@RequestMapping(value="/contacts/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Contact contact) {
		contactService.save(contact);
		return "redirect:/contacts";
	}
	
	//@RequestMapping("contacts/delete/")
	@RequestMapping(value="/contacts/delete/", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		contactService.delete(id);
		return "redirect:/contacts";
	}
}
