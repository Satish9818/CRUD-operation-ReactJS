package org.jsp.secondlevelcachedemo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestCache {
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager em1 = factory.createEntityManager();
		EntityManager em2 = factory.createEntityManager();
		System.out.println(em1.find(Person.class, 2));
		System.out.println(em2.find(Person.class, 2));
		System.out.println(em1.find(Person.class, 3));
		System.out.println(em2.find(Person.class, 3));
		System.out.println(em1.find(Person.class, 3));
		System.out.println(em2.find(Person.class, 3));
	}
}
