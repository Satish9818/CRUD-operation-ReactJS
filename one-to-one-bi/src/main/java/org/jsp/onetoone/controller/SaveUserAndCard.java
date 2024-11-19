package org.jsp.onetoone.controller;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.onetoone.dto.PanCard;
import org.jsp.onetoone.dto.User;

public class SaveUserAndCard {
	public static void main(String[] args) {

		User u = new User();
		Scanner s = new Scanner(System.in);
		System.out.println("Set name,phone,DOB,PanNumber,Pincode");
		u.setName(s.next());
		u.setPhone(s.nextLong());

		PanCard card = new PanCard();
		card.setDob(LocalDate.parse(s.next()));
		card.setNumber(s.next());
		card.setPincode(s.nextInt());
		card.setUser(u);
		u.setCard(card);

		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(u);
		transaction.begin();
		transaction.commit();
	}
}
