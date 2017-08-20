package org.virtuskill.jersey.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.virtuskill.jersey.domain.Student;

public class StudentDAO {

	private static HashMap<Long, Student> students = new HashMap<Long, Student>();

	static {
		Student jack = new Student(100, "Jack", "III");
		Student john = new Student(101, "John", "III");
		Student mary = new Student(102, "Mary", "III");
		Student sofia = new Student(103, "Sofia", "VI");
		Student mark = new Student(104, "Mark", "VI");
		Student sam = new Student(105, "Sam", "VI");
		Student mike = new Student(106, "Mike", "V");

		students.put(jack.getId(), jack);
		students.put(john.getId(), john);
		students.put(mary.getId(), mary);
		students.put(sofia.getId(), sofia);
		students.put(mark.getId(), mark);
		students.put(sam.getId(), sam);
		students.put(mike.getId(), mike);
	}

	public List<Student> getAllStudentDetails() {
		return new ArrayList<Student>(students.values());
	}

	public Student getStudent(long id) {
		Student obj = students.get(id);
		return obj;
	}

	public Student addStudent(Student newStudent) {
		students.put(newStudent.getId(), newStudent);
		return newStudent;
	}

	public Student updateStudent(Student updtStudent) {
		Student obj = students.get(updtStudent.getId());
		obj.setId(updtStudent.getId());
		obj.setAdmissionDate(updtStudent.getAdmissionDate());
		obj.setName(updtStudent.getName());
		obj.setSection(updtStudent.getSection());
		return students.put(updtStudent.getId(), obj);
	}

	public Student deleteStudent(long id) {
		return students.remove(id);
	}
}
