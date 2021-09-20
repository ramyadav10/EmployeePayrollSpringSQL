package com.mastercode.eps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mastercode.eps.controller.dao.EmployeeRepo;
import com.mastercode.eps.model.Employee;

@RestController
public class EmployeePayrollController {

	@Autowired
	EmployeeRepo repository;
	
	@PostMapping("/saveEmployeeData")
	public String saveEmployeeData(@RequestBody Employee employee) {
		repository.save(employee);
		return "Employee Data is Saved";
	}
	@PutMapping("/updateEmployeeData/{id}")
	public String updateEmployeeData(@PathVariable Integer id, @RequestBody Employee employee) {
		Employee dataUpdate=repository.findByid(id);
		dataUpdate.setName(employee.getName());
		dataUpdate.setDepartment(employee.getDepartment());
		dataUpdate.setSalary(employee.getSalary());
				
		repository.save(dataUpdate);
		return "Employee Data is Updated";
	}
	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployee(){
		return repository.findAll();
	}
	@GetMapping("/getAllEmployee/{id}")
	public Employee getAllEmployee(@PathVariable Integer id){
		return repository.findByid(id);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable Integer id){
		repository.deleteById(id);
		return "Employee is Deleted...!";
	}
}
