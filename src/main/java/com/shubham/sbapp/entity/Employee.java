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

	/*
	 * public Employee() { // TODO Auto-generated constructor stub }
	 * 
	 * public Employee(Integer eid, String ename, double esalary, String place) {
	 * super(); this.eid = eid; this.ename = ename; this.esalary = esalary;
	 * this.place = place; }
	 * 
	 * public Integer getEid() { return eid; } public void setEid(Integer eid) {
	 * this.eid = eid; } public String getEname() { return ename; } public String
	 * getPlace() { return place; }
	 * 
	 * public void setPlace(String place) { this.place = place; }
	 * 
	 * public void setEname(String ename) { this.ename = ename; } public double
	 * getEsalary() { return esalary; } public void setEsalary(double esalary) {
	 * this.esalary = esalary; }
	 * 
	 * @Override public String toString() { return "Employee [eid=" + eid +
	 * ", ename=" + ename + ", esalary=" + esalary + ", place=" + place + "]"; }
	 */






}
