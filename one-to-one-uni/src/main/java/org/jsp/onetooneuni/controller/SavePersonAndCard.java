package org.jsp.onetooneuni.controller;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.onetooneuni.dto.AadharCard;
import org.jsp.onetooneuni.dto.Person;

public class SavePersonAndCard {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Person p = new Person();
		System.out.println("Enter Person Name,Age,Phone and Aadar Number,DOB and Address");
		p.setName(s.next());
		p.setAge(s.nextInt());
		p.setPhone(s.nextLong());

		AadharCard card = new AadharCard();
		card.setNumber(s.nextLong());
		card.setDob(LocalDate.parse(s.next()));
		card.setAddress(s.next());

		p.setCard(card);
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(p);
		manager.persist(card);
		transaction.begin();
		transaction.commit();

	}
}
