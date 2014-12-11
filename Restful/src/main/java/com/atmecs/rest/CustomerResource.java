package com.atmecs.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atmecs.service.PersonService;

@Component
@Path("/customer")
public class CustomerResource {
	@Autowired
	PersonService personService;

	/*
	 * @Autowired Neo4jTemplate temp;
	 */

	@POST
	@Path("/register")
	@Produces(MediaType.APPLICATION_JSON)
	public Response registerUser(JSONObject data) throws JSONException {

		boolean bool = personService.add((data.get("UserName")).toString(),
				(data.get("password")).toString());
		if (bool == true)
			return Response.status(200).entity("ok").build();
		else
			return Response.status(401).entity("ok").build();
	}

	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response loginDetails(JSONObject data) throws JSONException {

		String name = personService.find((data.get("username")).toString(),
				(data.get("password")).toString());
		if (name != null)
			return Response.status(200).entity(name).build();
		else
			return Response.status(401).entity(name).build();
	}
}
