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

import com.manali.flotilla.models.VehicleMaintenance;
import com.manali.flotilla.models.Country;
import com.manali.flotilla.models.State;
import com.manali.flotilla.models.VehicleMaintenance;
import com.manali.flotilla.repositories.VehicleMaintenanceRepository;
import com.manali.flotilla.services.VehicleMaintenanceService;
import com.manali.flotilla.services.VehicleService;
import com.manali.flotilla.services.SupplierService;

@Controller
public class VehicleMaintenanceController {

	@Autowired
	private VehicleMaintenanceService vehicleMaintenanceService;
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private SupplierService supplierService;
	
	@GetMapping("/vehicleMaintenances")
	public String getVehicleMaintenances(Model model) {
		 
		model.addAttribute("vehicleMaintenances", vehicleMaintenanceService.getVehicleMaintenances());
		model.addAttribute("vehicles", vehicleService.getVehicles());
		model.addAttribute("suppliers", supplierService.getSuppliers());
		
		return "vehicleMaintenance";
	}

	// save new vehicleMaintenance
	@PostMapping("/vehicleMaintenances/addnew")
	public String addVehicleMaintenance(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceService.save(vehicleMaintenance);
		return "redirect:/vehicleMaintenances";
	}

	// save new vehicleMaintenance
	@RequestMapping("vehicleMaintenances/findbyid/")
	@ResponseBody
	public Optional<VehicleMaintenance> getById(int id) {
		return vehicleMaintenanceService.getById(id);
	}
	
	@RequestMapping(value="/vehicleMaintenances/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceService.save(vehicleMaintenance);
		return "redirect:/vehicleMaintenances";
	}
	
	//@RequestMapping("vehicleMaintenances/delete/")
	@RequestMapping(value="/vehicleMaintenances/delete/", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		vehicleMaintenanceService.delete(id);
		return "redirect:/vehicleMaintenances";
	}
}
