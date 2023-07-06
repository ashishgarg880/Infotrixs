package com.infotrixs.employee.manage.system.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.infotrixs.employee.manage.system.entities.Employee;

@Component

public interface EmployeeService {
	public List<Employee> getEmployee(int id);
	
	public String addEmployee(Employee employee);
	
	public String putEmployee(int id,Employee employee);
	
	public String delEmployee(int id);
}
