package org.jsp.onetomanyuni.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetomanyuni.dto.Employee;

public class FindEmpByDeptName {
	public static void main(String[] args) {

		String jpql = "select d.emps from Department d where d.name=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();

		Scanner s = new Scanner(System.in);
		System.out.println("Enter The Department Name to display employee details");
		String name = s.next();
		Query q = manager.createQuery(jpql);
		q.setParameter(1, name);

		List<Employee> emps = q.getResultList();

		if (emps.size() > 0) {
			for (Employee e : emps) {
				System.out.println("Employee Id: " + e.getId());
				System.out.println("Employee Name: " + e.getName());
				System.out.println("Designation: " + e.getDesg());
				System.out.println("Salary: " + e.getSalary());

				System.out.println("=======================================");
			}
		} else {
			System.err.println("No Employees present in Entered Department");
		}

	}
}
