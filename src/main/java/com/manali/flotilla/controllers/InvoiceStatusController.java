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

import com.manali.flotilla.models.InvoiceStatus;
import com.manali.flotilla.services.InvoiceStatusService;

@Controller
public class InvoiceStatusController {

	@Autowired
	private InvoiceStatusService invoiceStatusService;
	
	@GetMapping("/invoiceStatuses")
	public String getInvoiceStatuss(Model model) {
		List<InvoiceStatus> lstinvoiceStatus = invoiceStatusService.getInvoiceStatuses();
		 
		model.addAttribute("invoiceStatuses", lstinvoiceStatus);
		
		return "invoiceStatus";
	}

	// save new invoiceStatus
	@PostMapping("/invoiceStatuses/addnew")
	public String addInvoiceStatus(InvoiceStatus invoiceStatus) {
		invoiceStatusService.save(invoiceStatus);
		return "redirect:/invoiceStatuses";
	}

	// save new invoiceStatus
	@RequestMapping("invoiceStatuses/findbyid/")
	@ResponseBody
	public Optional<InvoiceStatus> getById(int id) {
		return invoiceStatusService.getById(id);
	}
	
	@RequestMapping(value="/invoiceStatuses/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(InvoiceStatus invoiceStatus) {
		invoiceStatusService.save(invoiceStatus);
		return "redirect:/invoiceStatuses";
	}
	
	//@RequestMapping("invoiceStatuses/delete/")
	@RequestMapping(value="/invoiceStatuses/delete/", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		invoiceStatusService.delete(id);
		return "redirect:/invoiceStatuses";
	}
}
