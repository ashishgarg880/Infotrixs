package com.infotrixs.employee.manage.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotrixs.employee.manage.system.dao.EmployeeRepository;
import com.infotrixs.employee.manage.system.entities.Employee;
import com.infotrixs.employee.manage.system.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {	
		
	@Autowired
	public EmployeeRepository employeeRepository;
	private Employee employee;
	
	public List<Employee> getEmployee(int id) {
		List<Employee> list = new ArrayList(); 
		list = this.employeeRepository.findAll();
		if(id == 0) {
			return list;
		}
		list = list.stream().filter(n -> n.getEmpNo() == id).collect(Collectors.toList());
		return list;
	}
	
	public String addEmployee(Employee employee) {
		List<Employee> list = new ArrayList(); 
		list = this.employeeRepository.findAll();
		list = list.stream().filter(n -> n.getEmpNo() == employee.getEmpNo()).collect(Collectors.toList());
		if(list.size() > 0) {
			return "Data is Exist";
		}
		employeeRepository.save(employee);
		return "Complete Save";
	}
	
	public String putEmployee(int id,Employee employee) {
		employeeRepository.save(employee);
		return "Complete Save";
	}
	
	public String delEmployee(int id) {
		List<Employee> list = new ArrayList(); 
		list = this.employeeRepository.findAll();
		list = list.stream().filter(n -> n.getEmpNo() == id).collect(Collectors.toList());
		if(list.size() > 0) {
			employeeRepository.deleteById(id);
			return "Deleted Data";
		}
		return  "Data is not exist";
	}
	
	public String addManaging(Employee employee) {
		return "";
	}
}
