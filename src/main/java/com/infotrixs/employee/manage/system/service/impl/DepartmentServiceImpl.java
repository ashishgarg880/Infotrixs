package com.infotrixs.employee.manage.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotrixs.employee.manage.system.dao.DepartmentRepository;
import com.infotrixs.employee.manage.system.dao.ManagingRepository;
import com.infotrixs.employee.manage.system.entities.Department;
import com.infotrixs.employee.manage.system.entities.Managing;
import com.infotrixs.employee.manage.system.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	Logger logger = LogManager.getLogger(DepartmentServiceImpl.class);
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private ManagingRepository managingRepository;
	
	@Override
	public List<Department> getAllDepartment(String id) {
		// TODO Auto-generated method stub
		List<Department> list = new ArrayList<>();
		list = departmentRepository.findAll();
		list = list.stream().filter(n-> n.getDeptId().equals(id)).collect(Collectors.toList());
		return list;
//		
	}
	
	public List<Department> getAllDepartment() {
		List<Department> list = new ArrayList<>();
		list = departmentRepository.findAll();
		return list;
	}

	@Override
	public String addDepartment(Department department) {
		// TODO Auto-generated method stub
		List<Department> list = new ArrayList<>();
		list = departmentRepository.findAll();
		list = list.stream().filter(n -> n.getDeptId().equals(department.getDeptId())).collect(Collectors.toList());
//		logger.debug(list);
		if(list.size() > 0) {
			return "Data is already exist";
		}
		departmentRepository.save(department);
		return "Complete Save";
	}
	
	public List<Managing> getManagingDepartment() {
		List<Managing> list = new ArrayList<>();
		list = managingRepository.findAll();
		return list;
	}
	
	public String addManagingDepartment(Managing managing) {
		List<Managing> list = new ArrayList<>();
		list = managingRepository.findAll();
		list = list.stream().filter(n -> n.getManagerId().equals(managing.getManagerId()) && n.getEmpId().equals(managing.getEmpId())).collect(Collectors.toList());
		if(list.size() > 0) {
			return "Data is already exist";		
		}
		managingRepository.save(managing);
		return "Complete Save";
	}
	
	public String deleteManagingDepartment(int managingId) {
		List<Managing> list = new ArrayList<>();
		list = managingRepository.findAll();
		list = list.stream().filter(n -> n.getManagingId() == managingId).collect(Collectors.toList());
		if(list.size() > 0) {
			managingRepository.deleteById(String.valueOf(managingId));
			return "Data is Delete";
		}
		return "Managing Id is not exist";
	}

	@Override
	public String deleteDepartment(String deptId) {
		// TODO Auto-generated method stub
		List<Department> list = new ArrayList<>();
		list = departmentRepository.findAll();
		list = list.stream().filter(n -> n.getDeptId() == deptId).collect(Collectors.toList());
		if(list.size() > 0) {
			managingRepository.deleteById(String.valueOf(deptId));
			return "Data is Delete";
		}
		return "Department Id is not exist";
		
	}

}
