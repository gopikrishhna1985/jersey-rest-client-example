package org.virtuskill.jersey.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.virtuskill.jersey.domain.Student;
import org.virtuskill.jersey.repository.StudentDAO;

@Path("/student")
public class StudentService {

	StudentDAO studentDAO = new StudentDAO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getStudentDetails() {
		return studentDAO.getAllStudentDetails();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudent(@PathParam(value = "id") long id) {
		return studentDAO.getStudent(id);
	}

	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Student addStudent(Student stdReqObj) {
		return studentDAO.addStudent(stdReqObj);
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Student updateStudent(Student stdReqObj) {
		return studentDAO.updateStudent(stdReqObj);
	}

	@DELETE
	@Path("/delete/{id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Student deleteStudent(@PathParam(value = "id") long id) {
		return studentDAO.deleteStudent(id);
	}
}
