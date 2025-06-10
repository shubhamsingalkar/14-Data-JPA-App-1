package com.shubham.sbapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@NoArgsConstructor
@Entity
public class Employee {

	@Id
	private Integer eid;
	private String ename;
	private double esalary;
	private String place;








}
