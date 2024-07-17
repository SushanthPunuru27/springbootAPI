package com.springboot.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.springboot.restapi.entity.Student;
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
		if(studentRepository.existsByRollNo(student.getRollNo())) {
			throw new RollNoAlreadyExistsException("Roll number already exists: " + student.getRollNo());
		}
		if(student.getPercentage() < 23) {
			throw new PercentageInvalidException("Percentage should be at least 23 Please update it");
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
	        if (updateStudent.getPercentage() != 0) {
	            student.setPercentage(updateStudent.getPercentage());
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
