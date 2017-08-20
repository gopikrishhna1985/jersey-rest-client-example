package org.virtuskill.jersey.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.virtuskill.jersey.domain.Student;

public class RestClient3 {

	private static Client client = ClientBuilder.newClient();

	public static void main(String[] args) {
		// Make POST call
		WebTarget basePath = client.target("http://localhost:8080/jersey-rest-api/jerseyWebApp/");
		WebTarget entityPath = basePath.path("student");
		WebTarget sendPostMessagePath = entityPath.path("insert");

		Student studentObj = new Student(112, "Mongo", "X");
		Response responseObj = sendPostMessagePath.request().post(Entity.json(studentObj));
		String message = responseObj.readEntity(String.class);
		System.out.println(message);
	}

}
