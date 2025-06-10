package com.shubham.sbapp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.shubham.sbapp.entity.Employee;
import com.shubham.sbapp.repo.EmpRepository;

@Service
public class EmpService {

	@Autowired
	private EmpRepository empRepo; // Field injection

	/*
	 * List<Employee> ee = new ArrayList<>(Arrays.asList(
	 * 
	 * 
	 * new Employee (101, "Vrushabh", 15000), new Employee(108, "Shubham", 98000)
	 * ));
	 */
	/*
	 * public EmpService(EmpRepository empRepo) { // Constructor injection, no need
	 * to write @Autowired this.empRepo = empRepo; }
	 */

	public List<Employee> saveEmployee(List<Employee> emp) {

		System.out.println("Impl class: " +empRepo.getClass().getSimpleName()); // Proxy impl class which implements the CrudRepository

		//Employee e = new Employee();

		//e.setEid(102);
		//e.setEname("Shubh");
		//e.setEsalary(80000);

		//Inserting record 
		empRepo.saveAll(emp);

		System.out.println(" Record inserted.......");

		return emp;
	}

	public Employee saveEmployee(Employee emp) {

		empRepo.save(emp);

		System.out.println("Single record inserted....");

		return emp;
	}

	public List<Employee> findMultiple(List<Integer> list){

		List<Employee> employees = (List<Employee>) empRepo.findAllById(list);

		employees.forEach(e -> System.out.println(e));// To print on console

		return employees; 

	}

	public  Employee findOne(int id) {

		// Optional<Employee> employee = empRepo.findById(id); ---- Returns Optional class

		Employee employee = empRepo.findById(id).get(); // Directly returns the objects by using get() method after findId() method

		return employee;
	}


	//Retrieve the data based on non-primary key variable.
	public List<Employee> findByName(String name){


		List<Employee> byEname = empRepo.findByEname(name); //Ename is variable in the Entity class


		return byEname;
	}

	//find salary greater than specified value
	public List<Employee> findGreaterSalary(double salary){

		List<Employee> byEsalaryGreaterThan = empRepo.findByEsalaryGreaterThan(salary);

		return byEsalaryGreaterThan;
	}

	//HQL 
	public List<Employee> getAllByHQL() {

		List<Employee> all = empRepo.getAllByHQL();

		System.out.println(all);

		return all;
	}

	public Employee getOneByHQL(@PathVariable Integer id) {
		Employee hql = empRepo.getEmpByIdByHQL(id);

		return hql;
	}






}




