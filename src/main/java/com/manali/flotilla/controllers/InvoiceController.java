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

import com.manali.flotilla.models.Client;
import com.manali.flotilla.models.Invoice;
import com.manali.flotilla.models.InvoiceStatus;
import com.manali.flotilla.services.ClientService;
import com.manali.flotilla.services.InvoiceService;
import com.manali.flotilla.services.InvoiceStatusService;

@Controller
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;

	@Autowired
	private ClientService clientService;

	@Autowired
	private InvoiceStatusService invoiceStatusService;
	
	@GetMapping("/invoices")
	public String getInvoices(Model model) {
		List<Invoice> lstinvoice = invoiceService.getInvoices();
		model.addAttribute("invoices", lstinvoice);
		
		List<Client> lstClients = clientService.getClients();
		model.addAttribute("clients", lstClients);
		
		List<InvoiceStatus> lstinvoiceStatuses = invoiceStatusService.getInvoiceStatuses();
		model.addAttribute("invoiceStatuses", lstinvoiceStatuses);
		
		return "invoice";
	}

	// save new invoice
	@PostMapping("/invoices/addnew")
	public String addinvoice(Invoice invoice) {
		invoiceService.save(invoice);
		return "redirect:/invoices";
	}

	// save new invoice
	@RequestMapping("invoices/findbyid/")
	@ResponseBody
	public Optional<Invoice> getById(int id) {
		return invoiceService.getById(id);
	}
	
	@RequestMapping(value="/invoices/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Invoice invoice) {
		invoiceService.save(invoice);
		return "redirect:/invoices";
	}
	
	//@RequestMapping("invoices/delete/")
	@RequestMapping(value="/invoices/delete/", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		invoiceService.delete(id);
		return "redirect:/invoices";
	}
}
