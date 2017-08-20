package org.virtuskill.jersey.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.virtuskill.jersey.domain.Student;

public class RestClient2 {
	private static Client client = ClientBuilder.newClient();

	public static void main(String[] args) {
		WebTarget basePath = client.target("http://localhost:8080/jersey-rest-api/jerseyWebApp/");
		WebTarget entityPath = basePath.path("student");
		
		WebTarget pathParam = entityPath.path("{id}");
		String response1 = pathParam.resolveTemplate("id", "102").request(MediaType.APPLICATION_JSON)
				.get(String.class);
		String response2 = pathParam.resolveTemplate("id", "110").request(MediaType.APPLICATION_JSON)
				.get(String.class);
		
		//We can also get the Student Object as response instead of the String class
		Student student = pathParam.resolveTemplate("id", "106").request(MediaType.APPLICATION_JSON)
				.get(Student.class);

		System.out.println(response1);
		System.out.println(response2);
		System.out.println(student.getId());
	}

}
