package com.atmecs.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import com.atmecs.domain.Person;

public interface PersonRepository extends GraphRepository<Person> {

	@Query("match n where n.name={0} return n.name")
	public String findUserByName(String name);

	@Query("match n where n.name={0} and n.password={1} return n.name")
	public String findUserByCredentials(String name, String password);

}
