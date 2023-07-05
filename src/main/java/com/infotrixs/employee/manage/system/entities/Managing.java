package com.infotrixs.employee.manage.system.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "managing")
public class Managing {
	
	@Id
	@Column(name = "id_managing")
	private int managingId;
	@Column(name = "dept_id")
	private String deptId;
	@Column(name = "manager_id")
	private String managerId;
	@Column(name = "emp_id")
	private String empId;
	
	public Managing() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Managing(int managingId,String deptId, String managerId, String empId) {
		super();
		this.managingId = managingId;
		this.deptId = deptId;
		this.managerId = managerId;
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "Managing [managingId=" + managingId + ",deptId=" + deptId + ", managerId=" + managerId + ", empId=" + empId + "]";
	}
	
	public int getManagingId() {
		return managingId;
	}
	
	public void setManagingId(int managingId) {
		this.managingId = managingId;
	}
	
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
}
