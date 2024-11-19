package org.jsp.onetooneuni.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetooneuni.dto.Person;

public class FindPersonByAadharId {

	public static void main(String[] args) {
		String qry = "select p from Person p where p.card.id=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createQuery(qry);
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Aadhar Id to display person details");
		int id = s.nextInt();
		q.setParameter(1, id);
		try {
			Person p = (Person) q.getSingleResult();
			System.out.println("Person ID: " + p.getId());
			System.out.println("Name: " + p.getName());
		} catch (NoResultException e) {
			System.err.println("Invalid aadhar Card");
		}
	}
}
