package com.atmecs.domain;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity
public class Person {

	@GraphId
	Long id;

	@Indexed(unique = true)
	public String name;
	public String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Person> getTeammates() {
		return teammates;
	}

	public void setTeammates(Set<Person> teammates) {
		this.teammates = teammates;
	}

	public Person() {
	}

	public Person(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	@RelatedTo(type = "TEAMMATE", direction = Direction.BOTH)
	public @Fetch
	Set<Person> teammates;

	public void worksWith(Person person) {
		if (teammates == null) {
			teammates = new HashSet<Person>();
		}
		teammates.add(person);
	}

}
