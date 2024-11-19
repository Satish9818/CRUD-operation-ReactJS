package org.jsp.onetooneuni.controller;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetooneuni.dto.Person;

public class FindPersonByAadharNumberAndDob {

	public static void main(String[] args) {
		String qry = "select p from Person p where p.card.number=?1 and p.card.dob=?2";
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createQuery(qry);
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Aadhar number and dob of birth(1947-8-15");
		long number = s.nextLong();
		LocalDate dob = LocalDate.parse(s.next());
		q.setParameter(1, number);
		q.setParameter(2, dob);
		try {

			Person p = (Person) q.getSingleResult();
			System.out.println("Person ID: " + p.getId());
			System.out.println("Name: " + p.getName());
			System.out.println("Phone Number " + p.getPhone());
			System.out.println("Age: " + p.getAge());

		} catch (NoResultException e) {

			System.err.println("Invalid aadhar Number or DOB");
		}

	}
}
