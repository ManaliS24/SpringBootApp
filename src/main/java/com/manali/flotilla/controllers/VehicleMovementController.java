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

import com.manali.flotilla.models.VehicleMovement;
import com.manali.flotilla.services.SupplierService;
import com.manali.flotilla.services.VehicleMovementService;
import com.manali.flotilla.services.VehicleService;

@Controller
public class VehicleMovementController {

	@Autowired
	private VehicleMovementService vehicleMovementService;
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private SupplierService supplierService;
	
	@GetMapping("/vehicleMovements")
	public String getVehicleMovements(Model model) {
		 
		model.addAttribute("vehicleMovements", vehicleMovementService.getVehicleMovements());
		model.addAttribute("vehicles", vehicleService.getVehicles());
		model.addAttribute("suppliers", supplierService.getSuppliers());
		
		return "vehicleMovement";
	}

	// save new vehicleMovement
	@PostMapping("/vehicleMovements/addnew")
	public String addVehicleMovement(VehicleMovement vehicleMovement) {
		vehicleMovementService.save(vehicleMovement);
		return "redirect:/vehicleMovements";
	}

	// save new vehicleMovement
	@RequestMapping("vehicleMovements/findbyid/")
	@ResponseBody
	public Optional<VehicleMovement> getById(int id) {
		return vehicleMovementService.getById(id);
	}
	
	@RequestMapping(value="/vehicleMovements/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleMovement vehicleMovement) {
		vehicleMovementService.save(vehicleMovement);
		return "redirect:/vehicleMovements";
	}
	
	//@RequestMapping("vehicleMovements/delete/")
	@RequestMapping(value="/vehicleMovements/delete/", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		vehicleMovementService.delete(id);
		return "redirect:/vehicleMovements";
	}
}
