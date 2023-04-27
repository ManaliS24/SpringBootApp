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

import com.manali.flotilla.models.Vehicle;
import com.manali.flotilla.services.VehicleService;
import com.manali.flotilla.services.VehicleMakeService;
import com.manali.flotilla.services.VehicleTypeService;
import com.manali.flotilla.services.VehicleStatusService;
import com.manali.flotilla.services.VehicleModelService;
import com.manali.flotilla.services.EmployeeService;
import com.manali.flotilla.services.LocationService;



@Controller
public class VehicleController {


	@Autowired private VehicleService vehicleService;
	@Autowired private LocationService locationService;
	@Autowired private VehicleTypeService vehicleTypeService;
	@Autowired private VehicleMakeService vehicleMakeService;
	@Autowired private VehicleStatusService vehicleStatusService;
	@Autowired private VehicleModelService vehicleModelService;
	@Autowired private EmployeeService employeeService;

	
	@GetMapping("/vehicles")
	public String getVehicles(Model model) {
		
		model.addAttribute("vehicles", vehicleService.getVehicles());
		model.addAttribute("locations", locationService.getLocations());
		model.addAttribute("employees", employeeService.getEmployees());
		model.addAttribute("vehicleTypes", vehicleTypeService.getVehicleTypes());
		model.addAttribute("vehicleMakes", vehicleMakeService.getVehicleMakes());
		model.addAttribute("vehicleStatuses", vehicleStatusService.getVehicleStatuses());
		model.addAttribute("vehicleModels", vehicleModelService.getVehicleModels());
		
		return "vehicle";
	}

	// save new vehicle
	@PostMapping("/vehicles/addnew")
	public String addVehicle(Vehicle vehicle) {
		vehicleService.save(vehicle);
		return "redirect:/vehicles";
	}

	// save new vehicle
	@RequestMapping("vehicles/findbyid/")
	@ResponseBody
	public Optional<Vehicle> getById(int id) {
		return vehicleService.getById(id);
	}
	
	@RequestMapping(value="/vehicles/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Vehicle vehicle) {
		vehicleService.save(vehicle);
		return "redirect:/vehicles";
	}
	
	//@RequestMapping("vehicles/delete/")
	@RequestMapping(value="/vehicles/delete/", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		vehicleService.delete(id);
		return "redirect:/vehicles";
	}
}
