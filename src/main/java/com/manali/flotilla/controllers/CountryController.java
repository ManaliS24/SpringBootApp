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
import com.manali.flotilla.repositories.CountryRepository;
import com.manali.flotilla.services.CountryService;

@Controller
public class CountryController {

	@Autowired
	private CountryService countryService;

	@GetMapping("/countries")
	public String getCountries(Model model) {
		List<Country> lstCountry = countryService.getCountries();
		model.addAttribute("countries", lstCountry);
		return "country";
	}

	// save new country
	@PostMapping("/countries/addnew")
	public String addCountry(Country country) {
		countryService.save(country);
		return "redirect:/countries";
	}

	// save new country
	@RequestMapping("countries/findbyid/")
	@ResponseBody
	public Optional<Country> getById(int id) {
		return countryService.getById(id);
	}
	
	@RequestMapping(value="/countries/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Country country) {
		countryService.save(country);
		return "redirect:/countries";
	}
	
	//@RequestMapping("countries/delete/")
	@RequestMapping(value="countries/delete/", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		countryService.delete(id);
		return "redirect:/countries";
	}
}
