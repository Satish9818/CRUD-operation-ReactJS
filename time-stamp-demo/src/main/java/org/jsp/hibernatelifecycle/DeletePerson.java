package org.jsp.hibernatelifecycle;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeletePerson {
	public static void main(String[] args) {

		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Person p = manager.find(Person.class, 1);
		manager.remove(p);
		transaction.begin();
		transaction.commit();
	}
}
