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

import com.manali.flotilla.models.VehicleModel;
import com.manali.flotilla.services.VehicleModelService;

@Controller
public class VehicleModelController {

	@Autowired
	private VehicleModelService vehicleModelService;
	
	@GetMapping("/vehicleModels")
	public String getVehicleModels(Model model) {
		List<VehicleModel> lstvehicleModel = vehicleModelService.getVehicleModels();
		 
		model.addAttribute("vehicleModels", lstvehicleModel);
		
		return "vehicleModel";
	}

	// save new vehicleModel
	@PostMapping("/vehicleModels/addnew")
	public String addVehicleModel(VehicleModel vehicleModel) {
		vehicleModelService.save(vehicleModel);
		return "redirect:/vehicleModels";
	}

	// save new vehicleModel
	@RequestMapping("vehicleModels/findbyid/")
	@ResponseBody
	public Optional<VehicleModel> getById(int id) {
		return vehicleModelService.getById(id);
	}
	
	@RequestMapping(value="/vehicleModels/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleModel vehicleModel) {
		vehicleModelService.save(vehicleModel);
		return "redirect:/vehicleModels";
	}
	
	//@RequestMapping("vehicleModels/delete/")
	@RequestMapping(value="/vehicleModels/delete/", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		vehicleModelService.delete(id);
		return "redirect:/vehicleModels";
	}
}
