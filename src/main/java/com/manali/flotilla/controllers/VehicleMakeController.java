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

import com.manali.flotilla.models.VehicleMake;
import com.manali.flotilla.services.VehicleMakeService;

@Controller
public class VehicleMakeController {
	
	@Autowired
	private VehicleMakeService vehicleMakeService;
	
	@GetMapping("/vehicleMakes")
	public String getVehicleMakes(Model model) {
		List<VehicleMake> lstvehicleMake = vehicleMakeService.getVehicleMakes();
		 
		model.addAttribute("vehicleMakes", lstvehicleMake);
		
		return "vehicleMake";
	}

	// save new vehicleMake
	@PostMapping("/vehicleMakes/addnew")
	public String addVehicleMake(VehicleMake vehicleMake) {
		vehicleMakeService.save(vehicleMake);
		return "redirect:/vehicleMakes";
	}

	// save new vehicleMake
	@RequestMapping("vehicleMakes/findbyid/")
	@ResponseBody
	public Optional<VehicleMake> getById(int id) {
		return vehicleMakeService.getById(id);
	}
	
	@RequestMapping(value="/vehicleMakes/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleMake vehicleMake) {
		vehicleMakeService.save(vehicleMake);
		return "redirect:/vehicleMakes";
	}
	
	//@RequestMapping("vehicleMakes/delete/")
	@RequestMapping(value="/vehicleMakes/delete/", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		vehicleMakeService.delete(id);
		return "redirect:/vehicleMakes";
	}
}
