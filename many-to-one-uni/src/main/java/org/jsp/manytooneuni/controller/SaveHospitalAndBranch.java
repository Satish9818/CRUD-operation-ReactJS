package org.jsp.manytooneuni.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.manytooneuni.dto.Branch;
import org.jsp.manytooneuni.dto.Hospital;

public class SaveHospitalAndBranch {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		System.out.println("Enter Hospital Name,FounderName and Year of ESTD");
		Hospital h = new Hospital();
		h.setName(s.next());
		h.setFounder(s.next());
		h.setYear_of_estb(s.nextInt());

		System.out.println("-------------------------------");
		System.out.println("Enter Branch Name,email and Phone");

		Branch b1 = new Branch();
		b1.setName(s.next());
		b1.setEmail(s.next());
		b1.setPhone(s.nextLong());
		b1.setHospital(h);

		System.out.println("-------------------------------");
		System.out.println("Enter Branch Name,email and Phone");

		Branch b2 = new Branch();
		b2.setName(s.next());
		b2.setEmail(s.next());
		b2.setPhone(s.nextLong());
		b2.setHospital(h);

		manager.persist(b1);
		manager.persist(b2);
		transaction.begin();
		transaction.commit();

	}
}
