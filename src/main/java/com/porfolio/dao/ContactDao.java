package com.porfolio.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.porfolio.model.Contact;

@Repository
public interface ContactDao extends JpaRepository<Contact, Integer> {
	@SuppressWarnings("unchecked")
	Contact save(Contact u);
}
