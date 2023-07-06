package com.infotrixs.employee.manage.system.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.infotrixs.employee.manage.system.entities.Department;
import com.infotrixs.employee.manage.system.entities.Employee;
import com.infotrixs.employee.manage.system.entities.Managing;
import com.infotrixs.employee.manage.system.service.DepartmentService;
import com.infotrixs.employee.manage.system.service.EmployeeService;

@Repository
public class EmployeeDao {

	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private EmployeeService employeeService;
	
	public List<Employee> getEmployee(){
		List<Employee> list = new ArrayList<>();
		list = employeeService.getEmployee(0);
		return list;
	}
	
	public List<Employee> getEmployee(int id){
		List<Employee> list = new ArrayList<>();
		list = employeeService.getEmployee(id);
		return list;
	}
	
	public String addEmplyee(Employee employee) {
		return employeeService.addEmployee(employee);
	}
	

	
	public String putEmployee(int empId, Employee employee) {
		return this.employeeService.putEmployee(empId, employee);
	}
	public String deleteEmployee( int empId) {
		return this.employeeService.delEmployee(empId);
	}
	public List<Department> getDepartEmployee( String empId) {
		return this.departmentService.getAllDepartment(empId);
	}
	public List<Department> getAllDepartEmployee() {
		return this.departmentService.getAllDepartment();
	}
	
	public String addEmployee( Department department) {
		return this.departmentService.addDepartment(department);
	}
	public String deleteDepart( String deptId) {
		return this.departmentService.deleteDepartment(deptId);
	}
	
	public List<Managing> getManagingEmployee() {
		return this.departmentService.getManagingDepartment();
	}
	
	public String addManagingEmployee(@RequestBody Managing managing) {
		return this.departmentService.addManagingDepartment(managing);
	}
	
	public String deleteManagingEmployee(@PathVariable int managingId) {
		return this.departmentService.deleteManagingDepartment(managingId);
	}
}
