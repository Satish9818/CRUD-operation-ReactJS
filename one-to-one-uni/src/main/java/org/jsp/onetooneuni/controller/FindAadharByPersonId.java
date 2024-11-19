package org.jsp.onetooneuni.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetooneuni.dto.AadharCard;
import org.jsp.onetooneuni.dto.Person;

public class FindAadharByPersonId {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the person ID to find Aadhar Details");
		int id = s.nextInt();

		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();

		Query q = manager.createQuery("select p.card from Person p where p.id=?1");
		q.setParameter(1, id);

		try {

			AadharCard card = (AadharCard) q.getSingleResult();
			System.out.println("Aadhar Card: " + card.getId());
			System.out.println("Aadhar Number: " + card.getNumber());
			System.out.println("Date of Birth: " + card.getDob());
			System.out.println("Address: " + card.getAddress());
		} catch (NoResultException e) {

			System.err.println("No AadharCard found");
		}

	}
}
