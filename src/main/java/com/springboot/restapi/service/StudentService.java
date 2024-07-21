package com.springboot.restapi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.springboot.restapi.entity.InvalidPercentageException;
import com.springboot.restapi.entity.Student;
import com.springboot.restapi.exception.FieldValidationException;
import com.springboot.restapi.exception.PercentageInvalidException;
import com.springboot.restapi.exception.RollNoAlreadyExistsException;
import com.springboot.restapi.exception.StudentNotFoundException;
import com.springboot.restapi.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	public List<Student> getAllStudents(){
		List<Student> students = studentRepository.findAll();	
		return students;
	}
	
	public Student getStudent(int id) {
		return studentRepository.findById(id)
				.orElseThrow(() -> new StudentNotFoundException("Student not found with id: " +id));
	}
	
	public void createStudent(Student student) {
		Map<String, String> errors = new HashMap<>();
		if(studentRepository.existsByRollNo(student.getRollNo())) {
			errors.put("rollNo", "Roll number already exists: " + student.getRollNo());
		}
		if(student.getPercentage() < 23) {
			errors.put("percentage", "Percentage should be at least 23. Please update it.");
		}
		if (!errors.isEmpty()) {
            throw new FieldValidationException(errors);
        }
		studentRepository.save(student);
	}
	
	public Student updateStudent(int id, Student updateStudent) {
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new StudentNotFoundException("Student not found with id: " +id));
		if(student != null) {
			if (updateStudent.getName() != null) {
	            student.setName(updateStudent.getName());
	        }
	        if (updateStudent.getPercentage() >= 23) {
	            student.setPercentage(updateStudent.getPercentage());
	        }
	        else {
	        	throw new InvalidPercentageException("Percentage must be greater than 23.");
	        }
	        if (updateStudent.getBranch() != null) {
	            student.setBranch(updateStudent.getBranch());
	        }
		}
        studentRepository.save(student);
        return student;
	}
	
	public Student deleteStudent(int id) {
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new StudentNotFoundException("Student not found with id:" +id));
		studentRepository.delete(student);
		return student;
	}
	
}
