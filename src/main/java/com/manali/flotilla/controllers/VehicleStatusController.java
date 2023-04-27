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

import com.manali.flotilla.models.VehicleStatus;
import com.manali.flotilla.services.VehicleStatusService;

@Controller
public class VehicleStatusController {

	@Autowired
	private VehicleStatusService vehicleStatusService;
	
	@GetMapping("/vehicleStatuses")
	public String getVehicleStatuss(Model model) {
		List<VehicleStatus> lstvehicleStatus = vehicleStatusService.getVehicleStatuses();
		 
		model.addAttribute("vehicleStatuses", lstvehicleStatus);
		
		return "vehiclestatus";
	}

	// save new vehicleStatus
	@PostMapping("/vehicleStatuses/addnew")
	public String addVehicleStatus(VehicleStatus vehicleStatus) {
		vehicleStatusService.save(vehicleStatus);
		return "redirect:/vehicleStatuses";
	}

	// save new vehicleStatus
	@RequestMapping("vehicleStatuses/findbyid/")
	@ResponseBody
	public Optional<VehicleStatus> getById(int id) {
		return vehicleStatusService.getById(id);
	}
	
	@RequestMapping(value="/vehicleStatuses/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleStatus vehicleStatus) {
		vehicleStatusService.save(vehicleStatus);
		return "redirect:/vehicleStatuses";
	}
	
	//@RequestMapping("vehicleStatuses/delete/")
	@RequestMapping(value="/vehicleStatuses/delete/", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		vehicleStatusService.delete(id);
		return "redirect:/vehicleStatuses";
	}
}
