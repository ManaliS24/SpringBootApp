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

import com.manali.flotilla.models.JobTitle;
import com.manali.flotilla.services.JobTitleService;

@Controller
public class JobTitleController {

	@Autowired
	private JobTitleService jobTitleService;
	
	@GetMapping("/jobTitles")
	public String getJobTitles(Model model) {
		List<JobTitle> lstjobTitle = jobTitleService.getJobTitles();
		 
		model.addAttribute("jobTitles", lstjobTitle);
		
		return "jobtitle";
	}

	// save new jobTitle
	@PostMapping("/jobTitles/addnew")
	public String addJobTitle(JobTitle jobTitle) {
		jobTitleService.save(jobTitle);
		return "redirect:/jobTitles";
	}

	// save new jobTitle
	@RequestMapping("jobTitles/findbyid/")
	@ResponseBody
	public Optional<JobTitle> getById(int id) {
		return jobTitleService.getById(id);
	}
	
	@RequestMapping(value="/jobTitles/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(JobTitle jobTitle) {
		jobTitleService.save(jobTitle);
		return "redirect:/jobTitles";
	}
	
	//@RequestMapping("jobTitles/delete/")
	@RequestMapping(value="/jobTitles/delete/", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		jobTitleService.delete(id);
		return "redirect:/jobTitles";
	}
}
