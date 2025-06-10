package com.shubham.sbapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shubham.sbapp.entity.Employee;

@Repository // This annotation is optional here
public interface EmpRepository extends JpaRepository<Employee, Integer> {




	//Custom methods based on findByXXXX, to find data based on non-primary key

	public List<Employee> findByEname(String ename);
	//Ename --> it is non-primary key variable in the Entity class.


	public List<Employee> findByEsalaryGreaterThan(double salary);
	//will fire the query where salary is greater the specifies salary



	//HQL : Hibernate query language
	@Query("from Employee")
	//@Query(value = "select * from employee", nativeQuery = true)----> Direct SQL query we can fire by using nativeQuery
	public List<Employee> getAllByHQL();

	@Query("from Employee where eid=:eid")
	public Employee getEmpByIdByHQL(Integer eid);



}
