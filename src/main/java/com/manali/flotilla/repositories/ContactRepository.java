package com.manali.flotilla.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manali.flotilla.models.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
