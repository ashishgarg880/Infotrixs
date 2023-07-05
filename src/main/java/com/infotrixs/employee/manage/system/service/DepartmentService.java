package com.infotrixs.employee.manage.system.service;

import java.util.List;

import com.infotrixs.employee.manage.system.entities.Department;
import com.infotrixs.employee.manage.system.entities.Managing;

public interface DepartmentService {
	
	public List<Department> getAllDepartment();
	
	public List<Department> getAllDepartment(String id);
	
	public String addDepartment(Department department);
	
	public String addManagingDepartment(Managing managing);
	
	public List<Managing> getManagingDepartment();
	
	public String deleteManagingDepartment(int managingId);
	
	public String deleteDepartment(String deptId);
	
}
