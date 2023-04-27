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

import com.manali.flotilla.models.VehicleType;
import com.manali.flotilla.services.VehicleTypeService;

@Controller
public class VehicleTypeController {

	@Autowired
	private VehicleTypeService vehicleTypeService;
	
	@GetMapping("/vehicleTypes")
	public String getVehicleTypes(Model model) {
		List<VehicleType> lstvehicleType = vehicleTypeService.getVehicleTypes();
		 
		model.addAttribute("vehicleTypes", lstvehicleType);
		
		return "vehicleType";
	}

	// save new vehicleType
	@PostMapping("/vehicleTypes/addnew")
	public String addVehicleType(VehicleType vehicleType) {
		vehicleTypeService.save(vehicleType);
		return "redirect:/vehicleTypes";
	}

	// save new vehicleType
	@RequestMapping("vehicleTypes/findbyid/")
	@ResponseBody
	public Optional<VehicleType> getById(int id) {
		return vehicleTypeService.getById(id);
	}
	
	@RequestMapping(value="/vehicleTypes/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleType vehicleType) {
		vehicleTypeService.save(vehicleType);
		return "redirect:/vehicleTypes";
	}
	
	//@RequestMapping("vehicleTypes/delete/")
	@RequestMapping(value="/vehicleTypes/delete/", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		vehicleTypeService.delete(id);
		return "redirect:/vehicleTypes";
	}
}
