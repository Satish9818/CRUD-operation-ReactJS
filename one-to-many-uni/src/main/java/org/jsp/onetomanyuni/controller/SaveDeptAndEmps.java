package org.jsp.onetomanyuni.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.onetomanyuni.dto.Department;
import org.jsp.onetomanyuni.dto.Employee;

public class SaveDeptAndEmps {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.println("Enter Department and Location to Save");
		Department d = new Department();
		d.setName(s.next());
		d.setLocation(s.next());

		System.out.println("Enter Employee name,desg and salary");
		Employee e1 = new Employee();
		e1.setName(s.next());
		e1.setDesg(s.next());
		e1.setSalary(s.nextDouble());

		System.out.println("-------------------------------------------");

		System.out.println("Enter Employee name,desg and salary");
		Employee e2 = new Employee();
		e2.setName(s.next());
		e2.setDesg(s.next());
		e2.setSalary(s.nextDouble());

		System.out.println("-------------------------------------------");

		System.out.println("Enter Employee name,desg and salary");
		Employee e3 = new Employee();
		e3.setName(s.next());
		e3.setDesg(s.next());
		e3.setSalary(s.nextDouble());

		List<Employee> emps = new ArrayList<Employee>();
		emps.add(e1);
		emps.add(e2);
		emps.add(e3);

		d.setEmps(emps);

		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(d);
		transaction.begin();
		transaction.commit();

	}
}
