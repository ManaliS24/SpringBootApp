package com.manali.flotilla.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manali.flotilla.models.JobTitle;
import com.manali.flotilla.repositories.JobTitleRepository;

@Service
public class JobTitleService {

	@Autowired
	private JobTitleRepository jobTitleRepository;

	// return list of countries
	public List<JobTitle> getJobTitles() {
		return jobTitleRepository.findAll();
	}

	// save the jobTitle
	public void save(JobTitle jobTitle) {
		jobTitleRepository.save(jobTitle);
	}

	// get JobTitle by ID
	public Optional<JobTitle> getById(int id) {
		return jobTitleRepository.findById(id);
	}

	// get JobTitle by ID
	public boolean existsById(int id) {
		return jobTitleRepository.existsById(id);
	}

	// delete JobTitle by ID
	public void delete(Integer id) {
		jobTitleRepository.deleteById(id);
	}
}
