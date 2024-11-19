package org.jsp.secondlevelcachedemo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveUser {
	public static void main(String[] args) {

		Person p = new Person();
		p.setName("Jagdish");
		p.setPhone(222);

		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(p);
		transaction.begin();
		transaction.commit();
	}
}
