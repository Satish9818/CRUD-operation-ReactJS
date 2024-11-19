package org.jsp.manytooneuni.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytooneuni.dto.Hospital;

public class FindHospitalById {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Hospital ID to find Hospital Details");
		int id = s.nextInt();

		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();

		Query q = manager.createQuery("select h from Hospital h where h.id=?1");
		q.setParameter(1, id);

		try {
			Hospital h = (Hospital) q.getSingleResult();
			System.out.println("Hospital ID: " + h.getId());
			System.out.println("Hospital Founder Name: " + h.getFounder());
			System.out.println("Hospital Year of Establishment: " + h.getYear_of_estb());

		} catch (NoResultException e) {
			System.err.println("No Hospital Exists with this ID");
		}

	}
}
