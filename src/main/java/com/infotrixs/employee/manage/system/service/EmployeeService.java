package com.infotrixs.employee.manage.system.service;

import java.util.List;

import com.infotrixs.employee.manage.system.entities.Employee;

public interface EmployeeService {
	public List<Employee> getEmployee(int id);
	
	public Employee addEmployee(Employee employee);
	
	public Employee putEmployee(int id,Employee employee);
	
	public void delEmployee(int id);
	
}
