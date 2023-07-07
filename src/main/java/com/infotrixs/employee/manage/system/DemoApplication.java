package com.infotrixs.employee.manage.system;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infotrixs.employee.manage.system.dao.EmployeeDao;
import com.infotrixs.employee.manage.system.entities.Department;
import com.infotrixs.employee.manage.system.entities.Employee;
import com.infotrixs.employee.manage.system.entities.Managing;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	
	@Autowired
	public EmployeeDao employeeDao;
	
	public static String employeeSystem() {
		return "1. Add Employee\n\n2. Show Employee Details\n\n3. Delete Employee\n\n4.Update Employee";
	}
	
	public static String departmentSystem() {
		return "1.Add Department\n\n2. Show Department Details\n\n3. Delete Department\n\n4.Managing Data";
	}
	
	public static void main(String[] args) throws FileNotFoundException,ParseException,IOException,NullPointerException{
		SpringApplication.run(DemoApplication.class, args);
	
	}
	
	public static String showSearching () {
		return "1. All Employee\n\n 2.User By Id ";
	}
	
	public static String managingDepartment() {
		return "1. Show All Managing Staff\n\n2. Add Manager\n\n3. Delete Manging ";
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println(" <<<<<<      Employee Management System  >>>>>>>  ");
		System.out.println(" In which department are you working ");
		System.out.println("1. Employee          2. Department HR");
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter What you do? ");
		int t = sc.nextInt();
		JSONParser jsonParser = new JSONParser();
		Employee employee = new Employee();
		Department department = new Department();
		Managing managing = new Managing(); 
		switch(t) {
			case 1:
				try {
					FileReader fileReader = new FileReader("D:\\Java\\InfoTrixs\\infotrixs\\src\\main\\resources\\employee.json");
					Object object = jsonParser.parse(fileReader);
					ObjectMapper objectMapper = new ObjectMapper();
					employee = (Employee) objectMapper.convertValue(object, Employee.class);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
//				System.out.println(fileReader);
				String str = employeeSystem();
				System.out.println(str);
				int n = sc.nextInt();

				switch(n) {
					case 1:
						System.out.println(this.employeeDao.addEmplyee(employee));
						break;
					case 2:
						System.out.println(showSearching());
						int search = sc.nextInt();
						switch(search) {
							case 1: 
								this.employeeDao.getEmployee().forEach(s -> System.out.println(s));
								break;
							case 2:
								search = sc.nextInt();
								System.out.println(this.employeeDao.getEmployee(search));
							default :
								break;
						}
						break;
					case 3:
						System.out.println("Enter Employee Id: ");
						search = sc.nextInt();
						System.out.println(this.employeeDao.deleteEmployee(search));
						break;
					case 4:
						System.out.println(this.employeeDao.putEmployee(employee.getEmpNo(),employee));
						break;
				}
				break;
			case 2:
				try {
					FileReader fileRea = new FileReader("D:\\Java\\InfoTrixs\\infotrixs\\src\\main\\resources\\department.json");
					Object object = jsonParser.parse(fileRea);
					ObjectMapper objectMapper = new ObjectMapper();
					department = (Department) objectMapper.convertValue(object, Department.class);
				} catch(Exception e) {
					e.printStackTrace();
				}
				String s = departmentSystem();
				System.out.println(s);
				int n1 = sc.nextInt();
				switch(n1) {
					case 1:
						System.out.println(this.employeeDao.addEmployee(department));
						break;
					case 2:
						System.out.println("1. Show All Department\n\n 2. Department By Id:");
						n1 = sc.nextInt();
						switch(n1) {
							case 1:
								this.employeeDao.getAllDepartEmployee().forEach(d -> System.out.println(d));
								break;
							case 2:
								str = sc.next();
								System.out.println(this.employeeDao.getDepartEmployee(str));
								break;
							
							default:
								break;
						}
						break;
					case 3:
						System.out.println("Enter Department Id");
						str = sc.next();
						System.out.println(this.employeeDao.deleteDepart(str));
						break;
					case 4:
						try {
							FileReader fileRea = new FileReader("D:\\Java\\InfoTrixs\\infotrixs\\src\\main\\resources\\managing.json");
							Object object = jsonParser.parse(fileRea);
							ObjectMapper objectMapper = new ObjectMapper();
							managing = (Managing) objectMapper.convertValue(object, Managing.class);
						} catch(Exception e) {
							e.printStackTrace();
						}
						System.out.println(managingDepartment());
						System.out.println("Enter the which part you use?");
						n1 = sc.nextInt();
						switch(n1) {
							case 1:
								System.out.println(this.employeeDao.getManagingEmployee());
								break;
							case 2: 
								System.out.println(this.employeeDao.addManagingEmployee(managing));
								break;
							default:
								System.out.println("Enter the Managing Id: ");
								n1 = sc.nextInt();
								System.out.println(this.employeeDao.deleteManagingEmployee(n1));
								break;
						}
						break;
					default:
						System.out.println("Final");
						break;
						
				}
				break;
			default :
				System.out.println(">>> Last Statge >>>");
				break;
		}
	}
}
