package org.virtuskill.jersey.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class RestClient1 {
	private static Client client = ClientBuilder.newClient();

	public static void main(String[] args) {
		// return JSON by supplying the MediaType and informing the client that
		// you need a String as response
		String response = client.target("http://localhost:8080/jersey-rest-api/jerseyWebApp/student/102")
				.request(MediaType.APPLICATION_JSON).get(String.class);

		// to return XML - uncomment below
		// String response =
		// client.target("http://localhost:8080/jersey-rest-hateoas/hateos/student/102")
		// .request(MediaType.APPLICATION_JSON).get(String.class);

		System.out.println(response);
	}

}
