package com.springboot.restapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "student")
public class Student {

	@Id
	@Column(name = "rollno")
	private int rollNo;
	@Column(name = "studentName")
	private String name;
	@Column(name = "percentage")
	private float percentage;
	@Column(name = "branch")
	private String branch;
//We have used lombok dependency in our pom.xml so no need to use getters and setters.
	
	
//	public Student() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public Student(int rollNo, String name, float percentage, String branch) {
//		super();
//		this.rollNo = rollNo;
//		this.name = name;
//		this.percentage = percentage;
//		this.branch = branch;
//	}

//	public int getRollNo() {
//		return rollNo;
//	}
//
//	public void setRollNo(int rollNo) {
//		this.rollNo = rollNo;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public float getPercentage() {
//		return percentage;
//	}
//
//	public void setPercentage(float percentage) {
//		this.percentage = percentage;
//	}
//
//	public String getBranch() {
//		return branch;
//	}
//
//	public void setBranch(String branch) {
//		this.branch = branch;
//	}
//
//	@Override
//	public String toString() {
//		return "Student [rollNo=" + rollNo + ", name=" + name + ", percentage=" + percentage + ", branch=" + branch
//				+ "]";
//	}

}
