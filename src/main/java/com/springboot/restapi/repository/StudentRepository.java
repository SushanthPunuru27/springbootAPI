package com.springboot.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.restapi.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	boolean existsByRollNo(int rollNo);

}
