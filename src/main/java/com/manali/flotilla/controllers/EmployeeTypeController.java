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

import com.manali.flotilla.models.EmployeeType;
import com.manali.flotilla.services.EmployeeTypeService;

@Controller
public class EmployeeTypeController {

	@Autowired
	private EmployeeTypeService employeeTypeService;
	
	@GetMapping("/employeeTypes")
	public String getEmployeeTypes(Model model) {
		List<EmployeeType> lstemployeeType = employeeTypeService.getEmployeeTypes();
		 
		model.addAttribute("employeeTypes", lstemployeeType);
		
		return "employeeType";
	}

	// save new employeeType
	@PostMapping("/employeeTypes/addnew")
	public String addEmployeeType(EmployeeType employeeType) {
		employeeTypeService.save(employeeType);
		return "redirect:/employeeTypes";
	}

	// save new employeeType
	@RequestMapping("employeeTypes/findbyid/")
	@ResponseBody
	public Optional<EmployeeType> getById(int id) {
		return employeeTypeService.getById(id);
	}
	
	@RequestMapping(value="/employeeTypes/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(EmployeeType employeeType) {
		employeeTypeService.save(employeeType);
		return "redirect:/employeeTypes";
	}
	
	//@RequestMapping("employeeTypes/delete/")
	@RequestMapping(value="/employeeTypes/delete/", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		employeeTypeService.delete(id);
		return "redirect:/employeeTypes";
	}
}
