package com.manali.flotilla.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manali.flotilla.models.Invoice;
import com.manali.flotilla.repositories.InvoiceRepository;

@Service
public class InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;

	// return list of countries
	public List<Invoice> getInvoices() {
		return invoiceRepository.findAll();
	}

	// save the invoice
	public void save(Invoice invoice) {
		invoiceRepository.save(invoice);
	}

	// get Invoice by ID
	public Optional<Invoice> getById(int id) {
		return invoiceRepository.findById(id);
	}

	// get Invoice by ID
	public boolean existsById(int id) {
		return invoiceRepository.existsById(id);
	}

	// delete Invoice by ID
	public void delete(Integer id) {
		invoiceRepository.deleteById(id);
	}


}
