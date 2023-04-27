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

import com.manali.flotilla.models.Country;
import com.manali.flotilla.models.State;
import com.manali.flotilla.models.Employee;
import com.manali.flotilla.services.CountryService;
import com.manali.flotilla.services.StateService;
import com.manali.flotilla.services.EmployeeService;
import com.manali.flotilla.services.EmployeeTypeService;
import com.manali.flotilla.services.JobTitleService;

@Controller
public class EmployeeController {

	@Autowired private EmployeeService employeeService;
	@Autowired private EmployeeTypeService employeeTypeService;
	@Autowired private CountryService countryService;
	@Autowired private StateService stateService;
	@Autowired private JobTitleService jobTitleService;
	
	
	@GetMapping("/employees")
	public String getEmployees(Model model) {

		model.addAttribute("employees", employeeService.getEmployees());
		model.addAttribute("employeeTypes", employeeTypeService.getEmployeeTypes());
		model.addAttribute("countries", countryService.getCountries());
		model.addAttribute("states", stateService.getStates());
		model.addAttribute("jobTitles", jobTitleService.getJobTitles());
		
		return "employee";
	}

	// save new supplier
	@PostMapping("/employees/addnew")
	public String addEmployee(Employee employee) {
		employeeService.save(employee);
		return "redirect:/employees";
	}

	// save new supplier
	@RequestMapping("employees/findbyid/")
	@ResponseBody
	public Optional<Employee> getById(int id) {
		return employeeService.getById(id);
	}
	
	@RequestMapping(value="/employees/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Employee employee) {
		employeeService.save(employee);
		return "redirect:/employees";
	}
	
	//@RequestMapping("employees/delete/")
	@RequestMapping(value="/employees/delete/", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		employeeService.delete(id);
		return "redirect:/employees";
	}
}
