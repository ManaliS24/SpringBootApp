package com.manali.flotilla.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manali.flotilla.models.InvoiceStatus;
import com.manali.flotilla.repositories.InvoiceStatusRepository;

@Service
public class InvoiceStatusService {

	@Autowired
	private InvoiceStatusRepository invoiceStatusRepository;

	// return list of countries
	public List<InvoiceStatus> getInvoiceStatuses() {
		return invoiceStatusRepository.findAll();
	}

	// save the invoiceStatus
	public void save(InvoiceStatus invoiceStatus) {
		invoiceStatusRepository.save(invoiceStatus);
	}

	// get InvoiceStatus by ID
	public Optional<InvoiceStatus> getById(int id) {
		return invoiceStatusRepository.findById(id);
	}

	// get InvoiceStatus by ID
	public boolean existsById(int id) {
		return invoiceStatusRepository.existsById(id);
	}

	// delete InvoiceStatus by ID
	public void delete(Integer id) {
		invoiceStatusRepository.deleteById(id);
	}
}
