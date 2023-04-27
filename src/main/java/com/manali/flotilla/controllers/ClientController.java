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

import com.manali.flotilla.models.Country;
import com.manali.flotilla.models.Client;
import com.manali.flotilla.models.State;
import com.manali.flotilla.services.CountryService;
import com.manali.flotilla.services.ClientService;
import com.manali.flotilla.services.StateService;

@Controller
public class ClientController {

	@Autowired
	private ClientService clientService;

	@Autowired
	private StateService stateService;

	@Autowired
	private CountryService countryService;
	
	@GetMapping("/clients")
	public String getClients(Model model) {
		List<Client> lstclient = clientService.getClients();
		List<State> lststate = stateService.getStates();
		List<Country> lstcountry = countryService.getCountries(); 

		model.addAttribute("states", lststate);
		model.addAttribute("countries", lstcountry);
		model.addAttribute("clients", lstclient);
		
		return "client";
	}

	// save new client
	@PostMapping("/clients/addnew")
	public String addClient(Client client) {
		clientService.save(client);
		return "redirect:/clients";
	}

	// save new client
	@RequestMapping("clients/findbyid/")
	@ResponseBody
	public Optional<Client> getById(int id) {
		return clientService.getById(id);
	}
	
	@RequestMapping(value="/clients/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Client client) {
		clientService.save(client);
		return "redirect:/clients";
	}
	
	//@RequestMapping("clients/delete/")
	@RequestMapping(value="/clients/delete/", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		clientService.delete(id);
		return "redirect:/clients";
	}
}