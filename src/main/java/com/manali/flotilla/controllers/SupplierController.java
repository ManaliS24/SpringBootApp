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

import com.manali.flotilla.models.Supplier;
import com.manali.flotilla.models.Country;
import com.manali.flotilla.models.State;
import com.manali.flotilla.services.SupplierService;
import com.manali.flotilla.services.CountryService;
import com.manali.flotilla.services.StateService;

@Controller
public class SupplierController {

	@Autowired
	private SupplierService supplierService;

	@Autowired
	private StateService stateService;

	@Autowired
	private CountryService countryService;
	
	@GetMapping("/suppliers")
	public String getSuppliers(Model model) {
		List<Supplier> lstsupplier = supplierService.getSuppliers();
		List<State> lststate = stateService.getStates();
		List<Country> lstcountry = countryService.getCountries(); 

		model.addAttribute("states", lststate);
		model.addAttribute("countries", lstcountry);
		model.addAttribute("suppliers", lstsupplier);
		
		return "supplier";
	}

	// save new supplier
	@PostMapping("/suppliers/addnew")
	public String addSupplier(Supplier supplier) {
		supplierService.save(supplier);
		return "redirect:/suppliers";
	}

	// save new supplier
	@RequestMapping("suppliers/findbyid/")
	@ResponseBody
	public Optional<Supplier> getById(int id) {
		return supplierService.getById(id);
	}
	
	@RequestMapping(value="/suppliers/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Supplier supplier) {
		supplierService.save(supplier);
		return "redirect:/suppliers";
	}
	
	//@RequestMapping("suppliers/delete/")
	@RequestMapping(value="/suppliers/delete/", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		supplierService.delete(id);
		return "redirect:/suppliers";
	}
}
