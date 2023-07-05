package com.infotrixs.employee.manage.system.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@Column(name = "emp_no")
	private int empNo;
	@Column(name = "emp_name")
	private String empName;
	@Column(name = "emp_address")
	private String empAddress;
	@Column(name = "emp_mob")
	private long empMobNo;
	@Column(name = "dept_name")
	private String deptName;
	@Column(name = "emp_city")
	private String empCity;
	@Column(name = "emp_state")
	private String empState;
	@Column(name = "emp_pinCode")
	private String empPinCode;
	@Column(name = "emp_email")
	private String empEmail;
	@Column(name = "emp_dob")
	private String empDob;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int empNo, String empName, String empAddress, long empMobNo, String deptName, String empCity,
			String empState, String empPinCode, String empEmail, String empDob) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.empAddress = empAddress;
		this.empMobNo = empMobNo;
		this.deptName = deptName;
		this.empCity = empCity;
		this.empState = empState;
		this.empPinCode = empPinCode;
		this.empEmail = empEmail;
		this.empDob = empDob;
	}
	
	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", empAddress=" + empAddress + ", empMobNo="
				+ empMobNo + ", deptName=" + deptName + ", empCity=" + empCity + ", empState=" + empState
				+ ", empPinCode=" + empPinCode + ", empEmail=" + empEmail + ", empDob=" + empDob + "]";
	}
	
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public long getEmpMobNo() {
		return empMobNo;
	}
	public void setEmpMobNo(long empMobNo) {
		this.empMobNo = empMobNo;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getEmpCity() {
		return empCity;
	}
	public void setEmpCity(String empCity) {
		this.empCity = empCity;
	}
	public String getEmpState() {
		return empState;
	}
	public void setEmpState(String empState) {
		this.empState = empState;
	}
	public String getEmpPinCode() {
		return empPinCode;
	}
	public void setEmpPinCode(String empPinCode) {
		this.empPinCode = empPinCode;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getEmpDob() {
		return empDob;
	}
	public void setEmpDob(String empDob) {
		this.empDob = empDob;
	}	
}
