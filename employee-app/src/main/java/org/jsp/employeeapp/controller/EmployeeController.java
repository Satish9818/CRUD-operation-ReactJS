package org.jsp.employeeapp.controller;

import java.util.Scanner;

import org.jsp.employeeapp.dao.EmployeeDao;
import org.jsp.employeeapp.dto.Employee;

public class EmployeeController {
static EmployeeDao dao=new EmployeeDao();
static Scanner s=new Scanner(System.in);

public static void main(String[] args) {
	System.out.println("1.Save Employee");
	System.out.println("2.Update Employee");
	System.out.println("3.Find Employee by ID");
	System.out.println("4.Delete Employee by ID");
	System.out.println("5.Verify Employeee by Phone and Password");
	
	
	int choice=s.nextInt();
	
	switch(choice) {
	case 1:{
		save();
		break;
	}
	case 2:{
		update();
		break;
	}
	case 5:{
		verify();
		break;
	}
	}
}

public static void save() {
	System.out.println("Enter the Name,Designation,salary and Password");
	Employee e=new Employee();
	e.setName(s.next());
	e.setPhone(s.nextLong());
	e.setDesg(s.next());
	e.setSalary(s.nextDouble());
	e.setPassword(s.next());
	e=dao.saveEmployee(e);
	System.out.println("Employee saved with ID: "+e.getId());
}
public static void update() {
	System.out.println("Enter the Employee id to update");
	int id=s.nextInt();
	System.out.println("Enter the Name,Designation,salary and Password");
	Employee e=new Employee();
	e.setName(s.next());
	e.setPhone(s.nextLong());
	e.setDesg(s.next());
	e.setSalary(s.nextDouble());
	e.setPassword(s.next());
	e=dao.updateEmployee(e);

	if(e!=null) {
		System.out.println("Employee Updated");
	}else {
		System.out.println("cannot update as id is invalid");
	}
	}

public static void verify() {
	System.out.println("Enter the PHone number and password to verify");
	long phone=s.nextLong();
	String password=s.next();
	Employee e=dao.verifyEmployee(phone, password);
	if(e!=null) {
		System.out.println("verification Successful");
	}else {
		System.err.println("Invalid phone number or Password");
	}
}
}
