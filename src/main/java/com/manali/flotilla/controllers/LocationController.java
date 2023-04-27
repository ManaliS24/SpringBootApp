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
import com.manali.flotilla.models.Location;
import com.manali.flotilla.models.State;
import com.manali.flotilla.services.CountryService;
import com.manali.flotilla.services.LocationService;
import com.manali.flotilla.services.StateService;


@Controller
public class LocationController {

	@Autowired
	private LocationService locationService;

	@Autowired
	private StateService stateService;

	@Autowired
	private CountryService countryService;
	
	@GetMapping("/locations")
	public String getLocations(Model model) {
		List<State> lststate = stateService.getStates();
		List<Country> lstcountry = countryService.getCountries();
		List<Location> lstlocation = locationService.getLocations();
		 
		model.addAttribute("states", lststate);
		model.addAttribute("countries", lstcountry);
		model.addAttribute("locations", lstlocation);
		
		return "location";
	}

	// save new location
	@PostMapping("/locations/addnew")
	public String addLocation(Location location) {
		locationService.save(location);
		return "redirect:/locations";
	}

	// save new location
	@RequestMapping("locations/findbyid/")
	@ResponseBody
	public Optional<Location> getById(int id) {
		return locationService.getById(id);
	}
	
	@RequestMapping(value="/locations/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Location location) {
		locationService.save(location);
		return "redirect:/locations";
	}
	
	//@RequestMapping("locations/delete/")
	@RequestMapping(value="/locations/delete/", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		locationService.delete(id);
		return "redirect:/locations";
	}
}
