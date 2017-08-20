package org.virtuskill.jersey.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/simpleService")
public class SimpleService {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sendSimpleServiceMessage() {
		return "Simple Service Working fine!!!";
	}

}
