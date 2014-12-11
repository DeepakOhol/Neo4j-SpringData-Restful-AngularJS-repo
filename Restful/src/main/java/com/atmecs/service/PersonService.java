package com.atmecs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atmecs.domain.Person;
import com.atmecs.repository.PersonRepository;

@Service
public class PersonService {
	@Autowired
	PersonRepository personRepository;

	@Transactional
	public boolean add(String userName, String password) {

		String name = personRepository.findUserByName(userName);
		if (name == null) {
			personRepository.save(new Person(userName, password));
			return true;
		}

		else
			return false;

	}

	@Transactional
	public String find(String userName, String password) {
		return personRepository.findUserByCredentials(userName, password);
	}

}
