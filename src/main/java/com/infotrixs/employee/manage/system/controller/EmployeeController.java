package com.infotrixs.employee.manage.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infotrixs.employee.manage.system.entities.Department;
import com.infotrixs.employee.manage.system.entities.Employee;
import com.infotrixs.employee.manage.system.entities.Managing;
import com.infotrixs.employee.manage.system.service.DepartmentService;
import com.infotrixs.employee.manage.system.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeDao;
	
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("employee")
	public List<Employee> getEmployee() {
		return this.employeeDao.getEmployee(0);
	}
	
	@GetMapping("employee/{empId}")
	public List<Employee> getEmployee(@PathVariable int empId) {
		return this.employeeDao.getEmployee(empId);
	}
	
	@PostMapping("employee")
	public Employee addEmplyee(@RequestBody Employee employee) {
		return this.employeeDao.addEmployee(employee);
	}
	
	@PutMapping("employee/{empId}")
	public Employee putEmployee(@PathVariable int empId, @RequestBody Employee employee) {
		return this.employeeDao.putEmployee(empId, employee);
	}
	@DeleteMapping("employee/{empId}")
	public void deleteEmployee(@PathVariable int empId) {
		this.employeeDao.delEmployee(empId);
	}
	
	@GetMapping("department/{empId}")
	public List<Department> getDepartEmployee(@PathVariable String empId) {
		return this.departmentService.getAllDepartment(empId);
	}
	
	@GetMapping("department")
	public List<Department> getAllDepartEmployee() {
		return this.departmentService.getAllDepartment();
	}
	
	@PostMapping("department")
	public String addEmployee(@RequestBody Department department) {
		return this.departmentService.addDepartment(department);
	}
	
	@DeleteMapping("department/{deptId}")
	public String deleteDepart(@PathVariable String deptId) {
		return this.departmentService.deleteDepartment(deptId);
	}
	
	@GetMapping("department/managing")
	public List<Managing> getManagingEmployee() {
		return this.departmentService.getManagingDepartment();
	}
	
	@PostMapping("department/managing")
	public String addManagingEmployee(@RequestBody Managing managing) {
		return this.departmentService.addManagingDepartment(managing);
	}
	
	@DeleteMapping("department/managing/{managingId}")
	public String deleteManagingEmployee(@PathVariable int managingId) {
		return this.departmentService.deleteManagingDepartment(managingId);
	}
}
