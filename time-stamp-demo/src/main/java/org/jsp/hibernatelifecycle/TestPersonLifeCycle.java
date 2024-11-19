package org.jsp.hibernatelifecycle;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestPersonLifeCycle {
	public static void main(String[] args) {

		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Person p = new Person();// Transient State
		p.setName("ABC");
		p.setPhone(888);
		manager.persist(p);// Persistence State
		transaction.begin();
		transaction.commit();
		p.setName("Satish");
		p.setPhone(999);
		transaction.begin();
		transaction.commit();
		p.setName("jagdish");
		p.setPhone(100);

		transaction.begin();
		transaction.commit();
		manager.detach(p);// Detached State
		p.setName("Moina");
		p.setPhone(200);

		transaction.begin();
		transaction.commit();

	}
}
