package org.jsp.embeddedclassdemo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveUser {
	public static void main(String[] args) {

		UserId userId = new UserId();
		userId.setEmail("xyz@gmail.com");
		userId.setPhone(777);

		User u = new User();
		u.setUserId(userId);
		u.setName("ABC");
		u.setPassword("abc123");

		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(u);
		transaction.begin();
		transaction.commit();
	}
}
