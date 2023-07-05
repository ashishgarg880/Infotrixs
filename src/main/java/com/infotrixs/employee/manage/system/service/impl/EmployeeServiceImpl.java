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
	
	public Employee addEmployee(Employee employee) {
		employeeRepository.save(employee);
		return employee;
	}
	
	public Employee putEmployee(int id,Employee employee) {
		employeeRepository.save(employee);
		return employee;
	}
	
	public void delEmployee(int id) {
		employeeRepository.deleteById(id);
	}
	
	public String addManaging(Employee employee) {
		return "";
	}
}
