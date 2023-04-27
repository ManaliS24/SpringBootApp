package com.manali.flotilla.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manali.flotilla.models.VehicleHire;
import com.manali.flotilla.services.ClientService;
import com.manali.flotilla.services.VehicleHireService;
import com.manali.flotilla.services.VehicleService;
import com.manali.flotilla.services.LocationService;
@Controller
public class VehicleHireController {

	@Autowired
	private VehicleHireService vehicleHireService;
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private LocationService locationService;
	
	@GetMapping("/vehicleHires")
	public String getVehicleHires(Model model) {
		 
		model.addAttribute("vehicleHires", vehicleHireService.getVehicleHires());
		model.addAttribute("vehicles", vehicleService.getVehicles());
		model.addAttribute("clients", clientService.getClients());
		model.addAttribute("locations", locationService.getLocations());
		
		return "vehicleHire";
	}

	// save new vehicleHire
	@PostMapping("/vehicleHires/addnew")
	public String addVehicleHire(VehicleHire vehicleHire) {
		vehicleHireService.save(vehicleHire);
		return "redirect:/vehicleHires";
	}

	// save new vehicleHire
	@RequestMapping("vehicleHires/findbyid/")
	@ResponseBody
	public Optional<VehicleHire> getById(int id) {
		return vehicleHireService.getById(id);
	}
	
	@RequestMapping(value="/vehicleHires/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleHire vehicleHire) {
		vehicleHireService.save(vehicleHire);
		return "redirect:/vehicleHires";
	}
	
	//@RequestMapping("vehicleHires/delete/")
	@RequestMapping(value="/vehicleHires/delete/", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		vehicleHireService.delete(id);
		return "redirect:/vehicleHires";
	}
}
