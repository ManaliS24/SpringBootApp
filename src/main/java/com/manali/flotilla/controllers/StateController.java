package com.manali.flotilla.controllers;

import java.util.List;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manali.flotilla.models.Country;
import com.manali.flotilla.models.State;
import com.manali.flotilla.repositories.StateRepository;
import com.manali.flotilla.services.CountryService;
import com.manali.flotilla.services.StateService;

@Controller
public class StateController {

	@Autowired
	private StateService stateService;

	@Autowired
	private CountryService countryService;
	
	@GetMapping("/states")
	public String getStates(Model model) {
		List<State> lststate = stateService.getStates();
		model.addAttribute("states", lststate);
		
		List<Country> lstcountry = countryService.getCountries();
		model.addAttribute("countries", lstcountry);
		return "state";
	}

	// save new state
	@PostMapping("/states/addnew")
	public String addstate(State state) {
		stateService.save(state);
		return "redirect:/states";
	}

	// save new state
	@RequestMapping("states/findbyid/")
	@ResponseBody
	public Optional<State> getById(int id) {
		return stateService.getById(id);
	}
	
	@RequestMapping(value="/states/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(State state) {
		stateService.save(state);
		return "redirect:/states";
	}
	
	//@RequestMapping("states/delete/")
	@RequestMapping(value="/states/delete/", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		stateService.delete(id);
		return "redirect:/states";
	}
	
}
