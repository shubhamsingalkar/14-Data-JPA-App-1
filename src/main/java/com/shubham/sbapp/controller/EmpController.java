package com.shubham.sbapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.sbapp.entity.Employee;
import com.shubham.sbapp.service.EmpService;

@RestController
public class EmpController {

	@Autowired
	private EmpService empService;


	@PostMapping("/saveall")
	public ResponseEntity< List<Employee>> saveEmployee(@RequestBody List<Employee> emp) {

		System.out.println("Inside save method of controller......");

		List<Employee> saveEmployee = empService.saveEmployee(emp);
		System.out.println(saveEmployee);
		System.out.println( "Record inserted......");


		return new ResponseEntity<List<Employee>>(saveEmployee, HttpStatus.CREATED);
	}

	@PostMapping("/saveone")
	public ResponseEntity<Employee> saveone(@RequestBody Employee emp) {

		Employee saveEmployee = empService.saveEmployee(emp);


		return new ResponseEntity<Employee>(saveEmployee, HttpStatus.ACCEPTED);


	}

	@GetMapping("/getone/{id}")
	public Employee findOne(@PathVariable int id) {

		Employee employee = empService.findOne(id);

		return employee;

	}

	@GetMapping("/getmultiple")
	public ResponseEntity<List<Employee>> findMultiple(@RequestBody List<Integer> list){

		//[111, 108] -- body in the postman. list of ids

		List<Employee> multiple = empService.findMultiple(list);

		return new ResponseEntity<List<Employee>>(multiple, HttpStatus.OK);
	}

	@GetMapping("/getbyname/{str}")
	public List<Employee>findByName (@PathVariable String str){

		List<Employee> byName = empService.findByName(str); // It executes WHERE clause .....

		System.out.println(byName);
		return byName;
	}

	@GetMapping("/greatersalary/{salary}")
	List<Employee> findGreaterSalary(@PathVariable double salary){

		List<Employee> greaterSalary = empService.findGreaterSalary(salary);

		return greaterSalary;
	}

	@GetMapping("/getallbyhql")
	public List<Employee> getAllByUsingHQL(){

		List<Employee> allByHQL = empService.getAllByHQL();

		return allByHQL;
	}

	@GetMapping("/getonebyidbyhql/{id}")
	public Employee getOneByIdByHQL(@PathVariable Integer id) {

		Employee oneByHQL = empService.getOneByHQL(id);

		return oneByHQL;
	}



}
